//package com.Beelab.DAO;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.Beelab.Entity.Product;
//
//public interface ProductDAO extends JpaRepository<Product, Integer> {
//	@Query("SELECT p FROM product p WHERE p.category_id=?1")
//	List<Product> findByCategoryId(String cid);
//}
