package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> {
	@Query("SELECT p FROM Cart p WHERE p.user.id=?1")
	List<Cart> getAllcartByUserId(int cid);
}
