package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.ProductDetailDto;
import com.bahadirmemis.springboot.dto.ProductDto;
import com.bahadirmemis.springboot.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product converProductDtoToProduct(ProductDto urunDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto convertProductToProductDto(Product urun);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDetailDto converProductToProductDetailDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    List<ProductDetailDto> converAllProductListToProductDetailDtoList(List<Product> productList);

    @AfterMapping
    default void setNulls(@MappingTarget final Product product, ProductDto productDto){
        if (productDto.getCategoryId() == null){
            product.setCategory(null);
        }
    }
}
