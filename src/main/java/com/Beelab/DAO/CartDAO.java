package com.Beelab.DAO;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Beelab.Entity.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> {
	@Query("SELECT p FROM Cart p WHERE p.user.id=?1")
	List<Cart> getAllcartByUserId(int cid);

	@Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.user.id = :userId AND c.product.id = :productId")
    Cart deleteCartByProductId(@Param("userId") int userId, @Param("productId") int productId);
	
	
	 @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.created_at like :currentDateTime")
	    List<Cart> getCurrentCartByUser(@Param("userId") int userId, @Param("currentDateTime") LocalDateTime currentDateTime);
}
