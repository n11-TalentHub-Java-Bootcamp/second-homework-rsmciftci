package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.CategoryDto;
import com.bahadirmemis.springboot.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target = "upperCategoryId", source = "upperCategory.id")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(target = "upperCategoryId", source = "upperCategory.id")
    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

    @Mapping(target = "upperCategory.id", source = "upperCategoryId")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

    @AfterMapping
    default void setNulls(@MappingTarget Category category, CategoryDto categoryDto){
        if (categoryDto.getUpperCategoryId() == null){
            category.setUpperCategory(null);
        }
    }
}
