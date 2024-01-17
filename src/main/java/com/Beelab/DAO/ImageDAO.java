package com.Beelab.DAO;

import com.Beelab.Entity.Product;
import com.Beelab.Entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageDAO extends JpaRepository<ProductImage, Integer> {
    @Query("SELECT p FROM ProductImage p WHERE p.product.id=?1")
    List<ProductImage> findALLByProduct(Integer cid);
}
