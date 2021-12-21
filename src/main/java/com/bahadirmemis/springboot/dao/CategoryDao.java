package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {


    List<Category> findAllByUpperCategoryIsNullOrderByNameDesc();

    List<Category> findAllByNameEndsWith(String name);

}