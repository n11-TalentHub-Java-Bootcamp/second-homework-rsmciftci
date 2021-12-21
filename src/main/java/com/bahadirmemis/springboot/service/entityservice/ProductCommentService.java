package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.ProductCommentDao;
import com.bahadirmemis.springboot.entity.Product;
import com.bahadirmemis.springboot.entity.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCommentService {

    @Autowired
    private ProductCommentDao productCommentDao;



    public List<ProductComment> findAll(){
        return productCommentDao.findAll();
    }

    public List<ProductComment> findAllByProduct_Id(Long productId){
        return  productCommentDao.findAllByProduct_Id(productId);
    }

    public ProductComment save(ProductComment productComment){ return productCommentDao.save(productComment);}

    public void deleteById(Long productCommentId){ productCommentDao.deleteById(productCommentId); };

    public List<ProductComment> findAllByUser_Id(Long userId){
        return  productCommentDao.findAllByUser_Id(userId);
    }

}
