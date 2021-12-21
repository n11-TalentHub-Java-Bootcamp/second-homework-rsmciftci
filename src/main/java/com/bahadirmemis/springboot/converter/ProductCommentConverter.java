package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.ProductCommentDto;
import com.bahadirmemis.springboot.entity.ProductComment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "productId",source = "product.id")
    ProductCommentDto convertProductCommentToProductCommentDto(ProductComment productComment);
    List<ProductCommentDto> convertProductCommentListToProductCommentDtoList(List<ProductComment> productCommentList);

    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "productId",target = "product.id")
    ProductComment convertProductCommentDtoToProductComment(ProductCommentDto productCommentDto);


}
