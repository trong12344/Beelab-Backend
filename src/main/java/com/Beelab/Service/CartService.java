package com.Beelab.Service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Beelab.cartDto.AddToCartDto;
import com.Beelab.cartDto.updateCartDto;
import com.shop.clothing.common.Cqrs.HandleResponse;
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

