package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductCommentDao extends JpaRepository<ProductComment,Long> {



    List<ProductComment> findAllByUser_Id(Long userId);
    List<ProductComment> findAllByProduct_Id(Long productId);


}
