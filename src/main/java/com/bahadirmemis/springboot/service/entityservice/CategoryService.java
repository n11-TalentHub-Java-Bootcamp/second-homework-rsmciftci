package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.CategoryDao;
import com.bahadirmemis.springboot.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findAll(){
        return (List<Category>) categoryDao.findAll();
    }

    public Category findById(Long id){
        Optional<Category> optionalCategory = categoryDao.findById(id);

        Category category = null;
        if (optionalCategory.isPresent()){
            category = optionalCategory.get();
        }

        return category;
    }

    public Category save(Category category){
        return categoryDao.save(category);
    }

    public void delete(Category category){
        categoryDao.delete(category);
    }

    public void deleteById(Long id){
        categoryDao.deleteById(id);
    }

    public long count(){
        return categoryDao.count();
    }

    public List<Category> findAllByUpperCategoryIsNull(){
        return categoryDao.findAllByUpperCategoryIsNullOrderByNameDesc();
    }

    public List<Category> findAllByNameEndsWith(String adi){
        return categoryDao.findAllByNameEndsWith(adi);
    }
}