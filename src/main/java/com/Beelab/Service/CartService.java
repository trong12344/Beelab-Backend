package com.Beelab.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Beelab.Entity.Cart;

@Service
public interface CartService {
    Cart createCart(int userId, Cart createCartDTO);
    
    Cart deleteCartByProductId(int userId, int productId);
    
    List<Cart> getListCartByUser(int userId);
    
    Cart findOneById(int id);
    
    Cart update(Cart cart);
}

