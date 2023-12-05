package com.Beelab.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Beelab.Entity.Cart;

@Service
public interface CartService {
   public Cart createCart(Cart Cart);
    
   public Cart deleteCartByProductId(int userId, int productId);
   
   public List<Cart> getCurrentCartByUser(int userId);
    
   public List<Cart> getAllCartByUser(int userId);
    
   public Cart findOneById(int id);
    
   public Cart update(Cart cart);
}

