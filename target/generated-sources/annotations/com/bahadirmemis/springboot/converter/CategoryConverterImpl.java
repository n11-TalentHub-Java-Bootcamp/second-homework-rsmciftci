package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.CategoryDto;
import com.bahadirmemis.springboot.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T21:35:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class CategoryConverterImpl implements CategoryConverter {

    @Override
    public CategoryDto convertCategoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setUpperCategoryId( categoryUpperCategoryId( category ) );
        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setBreakdown( category.getBreakdown() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( convertCategoryToCategoryDto( category ) );
        }

        return list;
    }

    @Override
    public Category convertCategoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setUpperCategory( categoryDtoToCategory( categoryDto ) );
        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setBreakdown( categoryDto.getBreakdown() );

        setNulls( category, categoryDto );

        return category;
    }

    private Long categoryUpperCategoryId(Category category) {
        if ( category == null ) {
            return null;
        }
        Category upperCategory = category.getUpperCategory();
        if ( upperCategory == null ) {
            return null;
        }
        Long id = upperCategory.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getUpperCategoryId() );

        setNulls( category, categoryDto );

        return category;
    }
}
