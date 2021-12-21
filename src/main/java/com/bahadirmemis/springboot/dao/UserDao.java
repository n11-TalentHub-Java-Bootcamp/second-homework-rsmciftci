package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.entity.User;
import org.hibernate.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findUserByUserName(String username);
    User findUserByPhoneNumber(String phoneNumber);
    void deleteUserByUserNameAndPhoneNumber(String username, String phoneNumber);
    boolean existsByUserNameAndPhoneNumber(String username, String phoneNumber);

    User findUserById(Long userId);
    boolean existsByIdOrUserNameOrEmail(Long userId,String username, String email);



}
