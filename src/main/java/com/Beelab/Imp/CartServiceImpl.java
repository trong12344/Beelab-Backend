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
		
		return null;
	}

	@Override
	public List<Cart> getListCartByUser(int userId) {
		
		return cartDAO.getAllcartByUserId(userId);
	}

	@Override
	public Cart findOneById(int id) {
		
		return null;
	}

	@Override
	public Cart update(Cart cart) {
		
		return null;
	}

}
