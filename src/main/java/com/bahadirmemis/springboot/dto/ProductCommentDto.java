package com.bahadirmemis.springboot.dto;

import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.entity.User;

import javax.persistence.*;
import java.util.Date;

public class ProductCommentDto {


    private Long id;
    private String comment;
    private Date commentDate;
    private Long productId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
