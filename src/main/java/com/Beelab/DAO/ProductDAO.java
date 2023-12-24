package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
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
	
=======
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM product p WHERE p.category_id=?1")
	List<Product> findByCategoryId(String cid);
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
}
