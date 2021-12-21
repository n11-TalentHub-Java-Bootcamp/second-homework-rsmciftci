package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.ProductDetailDto;
import com.bahadirmemis.springboot.dto.ProductDto;
import com.bahadirmemis.springboot.entity.Category;
import com.bahadirmemis.springboot.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T21:35:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class ProductConverterImpl implements ProductConverter {

    @Override
    public Product converProductDtoToProduct(ProductDto urunDto) {
        if ( urunDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productDtoToCategory( urunDto ) );
        product.setId( urunDto.getId() );
        product.setName( urunDto.getName() );
        product.setPrice( urunDto.getPrice() );
        product.setRegistrationDate( urunDto.getRegistrationDate() );

        setNulls( product, urunDto );

        return product;
    }

    @Override
    public ProductDto convertProductToProductDto(Product urun) {
        if ( urun == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setCategoryId( urunCategoryId( urun ) );
        productDto.setId( urun.getId() );
        productDto.setName( urun.getName() );
        productDto.setPrice( urun.getPrice() );
        productDto.setRegistrationDate( urun.getRegistrationDate() );

        return productDto;
    }

    @Override
    public ProductDetailDto converProductToProductDetailDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDetailDto productDetailDto = new ProductDetailDto();

        productDetailDto.setProductPrice( product.getPrice() );
        productDetailDto.setProductName( product.getName() );
        productDetailDto.setCategoryName( productCategoryName( product ) );

        return productDetailDto;
    }

    @Override
    public List<ProductDetailDto> converAllProductListToProductDetailDtoList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductDetailDto> list = new ArrayList<ProductDetailDto>( productList.size() );
        for ( Product product : productList ) {
            list.add( converProductToProductDetailDto( product ) );
        }

        return list;
    }

    protected Category productDtoToCategory(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( productDto.getCategoryId() );

        return category;
    }

    private Long urunCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String productCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
