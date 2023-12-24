package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Beelab.Entity.Product;

import jakarta.transaction.Transactional;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(Integer cid);
	
	
	@Query("SELECT p FROM Product p WHERE p.supplier.id=?1")
	List<Product> findBySupplierId(Integer cid);
	
	  @Transactional
	  @Modifying
	  @Query("UPDATE Product p SET p.status = 0 WHERE p.status = 1")
	  public void updateStatusToZero();
	
}
