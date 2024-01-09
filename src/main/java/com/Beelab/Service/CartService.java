package com.Beelab.Service;


import java.util.Collection;

import com.Beelab.dto.cartDto.AddToCartDto;
import com.Beelab.dto.cartDto.updateCartDto;
import com.Beelab.Common.HandleResponse;
import org.springframework.stereotype.Service;

import com.Beelab.Entity.Cart;

@Service
public interface CartService {
   public HandleResponse<Cart> addToCart(AddToCartDto addToCartDto);
    
   public HandleResponse<Void> removeItemInCart(Integer removeItemsInCartDto);

   public HandleResponse<Cart> UpdateCart(updateCartDto updateCartDto);

   HandleResponse<Collection<Cart>> getAllCartByUser(Integer userId);

   public Cart findOneById(int id);

}

