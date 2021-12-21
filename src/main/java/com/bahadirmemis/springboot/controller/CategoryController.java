package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.converter.CategoryConverter;
import com.bahadirmemis.springboot.converter.ProductConverter;
import com.bahadirmemis.springboot.dto.CategoryDto;
import com.bahadirmemis.springboot.dto.ProductDetailDto;
import com.bahadirmemis.springboot.entity.Category;
import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.service.entityservice.CategoryService;
import com.bahadirmemis.springboot.service.entityservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<CategoryDto> findAll(){

        List<Category> categoryList = categoryService.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){

        Category category = categoryService.findById(id);

        return category;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto){ //TODO: Input should be Dto

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        category = categoryService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){//TODO: Input should be Dto

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        //TODO: Check it
        if (category.getUpperCategory() != null && category.getUpperCategory().getId() == null){
            category.setUpperCategory(null);
        }

        category = categoryService.save(category);

        CategoryDto categoryDeoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDeoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        categoryService.deleteById(id);
    }


    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long id){
        List<Product> productList = productService.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.converAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }
}
