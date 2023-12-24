 package com.Beelab.API;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Beelab.Entity.Cart;
import com.Beelab.Entity.Product;
import com.Beelab.Service.CartService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class CartAPI {
	@Autowired
	CartService cartService;
	
	@GetMapping("{id}")
	public List<Cart> getAllCartByUser(@PathVariable int id){
		return cartService.getAllCartByUser(id);
	}
	
//	@GetMapping("/current/{id}")
//	public List<Cart> getCurrentCartByUser(@PathVariable int id){
//		return cartService.getCurrentCartByUser(id);
//	}
	
	
	@PostMapping("/add")
	public Cart create(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}
}
