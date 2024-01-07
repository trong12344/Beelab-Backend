 package com.Beelab.API;


import java.util.Collection;
import java.util.List;

import com.Beelab.cartDto.AddToCartDto;
import com.Beelab.cartDto.updateCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<Collection<Cart>> getAllCartByUser(@PathVariable int id) {
		return ResponseEntity.ok(cartService.getAllCartByUser(id).get());
	}
	
//	@GetMapping("/current/{id}")
//	public List<Cart> getCurrentCartByUser(@PathVariable int id){
//		return cartService.getCurrentCartByUser(id);
//	}
	

	@DeleteMapping("/delete/{pid}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Integer pid){
		cartService.removeItemInCart(pid);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/add")
	public ResponseEntity<Cart> create(@RequestBody AddToCartDto cart) {
		return ResponseEntity.ok(cartService.addToCart(cart).orThrow());
	}

	@PutMapping("/update")
	public ResponseEntity<Cart> update(@RequestBody updateCartDto cart) {
		return ResponseEntity.ok(cartService.UpdateCart(cart).orThrow());
	}
}
