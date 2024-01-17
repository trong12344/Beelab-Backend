package com.Beelab.DAO;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Beelab.Entity.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {

    @Query("select c from Cart c where c.user_id = ?1 and c.ProductDetail.id = ?2")
    Optional<Cart> findByUserIdAndProductOptionId(Integer userId, Integer productDetailId);
    @Query("select c from Cart c where c.user_id = ?1")
    Collection<Cart> findAllByUserId(Integer userId);

//	@Query("SELECT p FROM Cart p WHERE p.user.id=?1")
//	List<Cart> getAllcartByUserId(int cid);
//
//	@Transactional
//    @Modifying
//    @Query("DELETE FROM Cart c WHERE c.user.id = :userId AND c.ProductDetail.id = :productId")
//    Cart deleteCartByProductId(@Param("userId") int userId, @Param("productId") int productId);
//
	
//	 @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.created_at like :currentDateTime")
//	    List<Cart> getCurrentCartByUser(@Param("userId") int userId, @Param("currentDateTime") LocalDateTime currentDateTime);
}
