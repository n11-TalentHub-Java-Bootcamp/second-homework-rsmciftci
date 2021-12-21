package com.bahadirmemis.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="PRODUCT_COMMENT")
public class ProductComment implements Serializable {

    @SequenceGenerator(name = "generatorOfProductCommentId", sequenceName ="PRODUCT_COMMENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generatorOfProductCommentId")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 500)
    private String comment;

    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public ProductComment() {
    }

    public ProductComment(Long id, String comment, Date commentDate, Product product, User user) {
        this.id = id;
        this.comment = comment;
        this.commentDate = commentDate;
        this.product = product;
        this.user = user;
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
