package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.CartDAO;
import com.Beelab.Entity.Cart;
import com.Beelab.Service.CartService;


@Service
public class CartServiceImpl implements CartService {
		@Autowired
		CartDAO cartDAO;
	
	public Cart createCart(Cart Cart) {
		return cartDAO.save(Cart);
	}

	@Override
	public Cart deleteCartByProductId(int userId, int productId) {
		return cartDAO.deleteCartByProductId(userId, productId);
	}
	@Override
	public List<Cart> getAllCartByUser(int userId) {
		return cartDAO.getAllcartByUserId(userId);
	}

	@Override
	public Cart findOneById(int id) {
		
		return cartDAO .findById(id).get();
	}

	@Override
	public Cart update(Cart cart) {
		
		return cartDAO .save(cart);
	}

//	@Override
//	public List<Cart> getCurrentCartByUser(int userId) {
//        LocalDate localDateTime = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String dateString = localDateTime.format(formatter);
//        LocalDateTime date1 = LocalDateTime.parse(dateString, formatter);
//
//
//		LocalDateTime date = LocalDateTime.now();
//
//		return cartDAO.getCurrentCartByUser(userId,date1);
//	}

	

}
