package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Beelab.Entity.Product;

import jakarta.transaction.Transactional;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(Integer cid);
	
	
	@Query("SELECT p FROM Product p WHERE p.supplierId=?1")
	List<Product> findBySupplierId(Integer cid);

	@Query(nativeQuery = true, value = "select * from product ")
	Page<Product> GetAll(Pageable pageable);

	@Query(value = "SELECT DISTINCT  p.product  FROM ProductDetail p WHERE " +
			" (:keyword IS NULL OR p.product.name LIKE %:keyword%)" +
			"AND  (:categoryIds IS NULL   or p.product.category.id IN :categoryIds)" +
			" AND (p.product.amount >= :minPrice)" +
			" AND ( p.product.amount <= :maxPrice)" +
//			" AND (p.deletedDate IS NULL)" +
			" AND (:colorIds IS NULL   or p.color.id IN :colorIds)" +
			" AND (:sizes IS NULL   or p.size IN :sizes)",
			countQuery = "SELECT count(DISTINCT p.product.id) FROM ProductDetail p WHERE " +
					" (:keyword IS NULL OR p.product.name LIKE %:keyword%)" +
					"AND  (:categoryIds IS NULL   or p.product.category.id IN :categoryIds)" +
					" AND (p.product.amount >= :minPrice)" +
					" AND ( p.product.amount <= :maxPrice)" +
//					" AND (p.deletedDate IS NULL)" +
					" AND (:colorIds IS NULL   or p.color.id IN :colorIds)" +
					" AND (:sizes IS NULL   or p.size IN :sizes)"

	)
	Page<Product> searchAllProducts(String keyword, int[] categoryId,
									int minPrice, int maxPrice,
									int[] colorId, String[] sizes,
									Pageable pageable);



}
