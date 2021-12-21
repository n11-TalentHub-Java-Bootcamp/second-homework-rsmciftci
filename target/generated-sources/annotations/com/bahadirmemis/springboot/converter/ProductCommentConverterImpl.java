package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.ProductCommentDto;
import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.entity.ProductComment;
import com.bahadirmemis.springboot.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T21:35:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class ProductCommentConverterImpl implements ProductCommentConverter {

    @Override
    public ProductCommentDto convertProductCommentToProductCommentDto(ProductComment productComment) {
        if ( productComment == null ) {
            return null;
        }

        ProductCommentDto productCommentDto = new ProductCommentDto();

        productCommentDto.setUserId( productCommentUserId( productComment ) );
        productCommentDto.setProductId( productCommentProductId( productComment ) );
        productCommentDto.setId( productComment.getId() );
        productCommentDto.setComment( productComment.getComment() );
        productCommentDto.setCommentDate( productComment.getCommentDate() );

        return productCommentDto;
    }

    @Override
    public List<ProductCommentDto> convertProductCommentListToProductCommentDtoList(List<ProductComment> productCommentList) {
        if ( productCommentList == null ) {
            return null;
        }

        List<ProductCommentDto> list = new ArrayList<ProductCommentDto>( productCommentList.size() );
        for ( ProductComment productComment : productCommentList ) {
            list.add( convertProductCommentToProductCommentDto( productComment ) );
        }

        return list;
    }

    @Override
    public ProductComment convertProductCommentDtoToProductComment(ProductCommentDto productCommentDto) {
        if ( productCommentDto == null ) {
            return null;
        }

        ProductComment productComment = new ProductComment();

        productComment.setUser( productCommentDtoToUser( productCommentDto ) );
        productComment.setProduct( productCommentDtoToProduct( productCommentDto ) );
        productComment.setId( productCommentDto.getId() );
        productComment.setComment( productCommentDto.getComment() );
        productComment.setCommentDate( productCommentDto.getCommentDate() );

        return productComment;
    }

    private Long productCommentUserId(ProductComment productComment) {
        if ( productComment == null ) {
            return null;
        }
        User user = productComment.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productCommentProductId(ProductComment productComment) {
        if ( productComment == null ) {
            return null;
        }
        Product product = productComment.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User productCommentDtoToUser(ProductCommentDto productCommentDto) {
        if ( productCommentDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( productCommentDto.getUserId() );

        return user;
    }

    protected Product productCommentDtoToProduct(ProductCommentDto productCommentDto) {
        if ( productCommentDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productCommentDto.getProductId() );

        return product;
    }
}
