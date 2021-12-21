package com.bahadirmemis.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="USERS")
public class User implements Serializable {

    @SequenceGenerator(name = "generatorOfUserId", sequenceName ="USER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generatorOfUserId")
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(length = 50)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;




    /*
    CascadeType.ALL is selected. If user is deleted, all comments belong to it, will be deleted too.
    Without user, product comments are assumed to be meaningless.
    Not sure if it's a good assumption. After deleting user we could store the comments of him/her
    and publish the comments with null username.
    No need to store them in database.
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ProductComment> productComments;

    @Column(length = 20)
    private String userName;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ProductComment> getProductComments() {
        return productComments;
    }

    public void setProductComments(List<ProductComment> productComments) {
        this.productComments = productComments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", productComments=" + productComments +
                ", userName='" + userName + '\'' +
                '}';
    }
}
