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
import com.Beelab.Entity.ProductDetail;
import com.Beelab.Service.ProductDetailServ;
import com.Beelab.Service.ProductService;



@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductAPI {
	@Autowired
	ProductService productService;

	@Autowired
	ProductDetailServ ProductDetailServ;

	
	@GetMapping()
	public List<Product> getAll() {
		return productService.findAll();
	}

	@GetMapping("{id}")
	public Product getById(@PathVariable("id") Integer id) {
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
}
