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

import com.Beelab.Entity.Product;
<<<<<<< HEAD
import com.Beelab.Entity.ProductDetail;
import com.Beelab.Service.ProductDetailServ;
=======
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
import com.Beelab.Service.ProductService;



@CrossOrigin("*")
@RestController
<<<<<<< HEAD
@RequestMapping("/products")
=======
@RequestMapping("/rest/products")
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
public class ProductAPI {
	@Autowired
	ProductService productService;

<<<<<<< HEAD
	@Autowired
	ProductDetailServ ProductDetailServ;

	
=======
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
	@GetMapping()
	public List<Product> getAll() {
		return productService.findAll();
	}

	@GetMapping("{id}")
<<<<<<< HEAD
	public Product getById(@PathVariable("id") Integer id) {
=======
	public Product getOne(@PathVariable("id") Integer id) {
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
		return productService.findById(id);
	}

	@PostMapping()
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
		return productService.update(product);
	}

	@DeleteMapping("{id}")
<<<<<<< HEAD
	public void delete(@PathVariable("id") Integer id) {	
		productService.delete(id);
	}
	
	@GetMapping("{id}/chi-tiet")
	public List<ProductDetail>  getProductDetail(@PathVariable("id") Integer id) {
		return  ProductDetailServ.getProductDetail(id);
	}
	
	@GetMapping("danh-muc/{id}")
	public List<Product> findByCategoryId(@PathVariable("id") Integer id) {
		return productService.findByCategoryId(id);
	}
	
	
=======
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
}
