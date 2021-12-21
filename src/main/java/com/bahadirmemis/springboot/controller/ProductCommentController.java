package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.converter.ProductCommentConverter;

import com.bahadirmemis.springboot.dto.ProductCommentDto;
import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.entity.ProductComment;
import com.bahadirmemis.springboot.entity.User;
import com.bahadirmemis.springboot.exception.ProductCommentNotFoundException;

import com.bahadirmemis.springboot.service.entityservice.ProductCommentService;

import com.bahadirmemis.springboot.service.entityservice.ProductService;

import com.bahadirmemis.springboot.service.entityservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productComments/")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    // (3.1)
    @GetMapping("users/{userId}")
    public List<ProductCommentDto> findProductCommentsOfUser(@PathVariable("userId") Long userId){


        List<ProductComment> productCommentList = productCommentService.findAllByUser_Id(userId);
        List<ProductCommentDto> productCommentListDto = ProductCommentConverter.INSTANCE.convertProductCommentListToProductCommentDtoList(productCommentList);

        if(productCommentListDto.isEmpty()){
            User user = userService.findUserById(userId);
            throw new ProductCommentNotFoundException( user.getName() + " hasn't commented yet!");
        }
        return productCommentListDto;
    }




    // (3.2)
    @GetMapping("products/{productId}")
    public List<ProductCommentDto> findAllCommentsOfProduct(@PathVariable("productId") Long productId){
        List<ProductComment> productCommentsList = productCommentService.findAllByProduct_Id(productId);
        List<ProductCommentDto> dtoList = ProductCommentConverter.INSTANCE.convertProductCommentListToProductCommentDtoList(productCommentsList);

        if(dtoList.isEmpty()){
            Product product = productService.findById(productId);
            throw new ProductCommentNotFoundException( product.getName() + " hasn't got any comment yet!");
        }
        return dtoList;
    }


    // (3.3)
    @PostMapping("")
    public ProductCommentDto saveProductComment(@RequestBody ProductCommentDto productCommentDto){
        ProductComment productComment = ProductCommentConverter.INSTANCE.convertProductCommentDtoToProductComment(productCommentDto);
        productComment = productCommentService.save(productComment);
        return productCommentDto;
    }

    // (3.4)
    @DeleteMapping("{id}")
    public void deleteProductComment(@PathVariable("id") Long productCommentId){
        productCommentService.deleteById(productCommentId);
    }



}
