package com.Beelab.API;

import java.util.List;

import com.Beelab.Common.Paginated;
import com.Beelab.dto.*;
import com.Beelab.Common.HandleResponse;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping()
	public ResponseEntity<Paginated<Product>> getAll(@Valid @ParameterObject getAllProductDto getAllProductDto) {
		return ResponseEntity.ok(productService.findAll(getAllProductDto).orThrow());
	}

	@GetMapping("/search")
	public ResponseEntity<Paginated<ProductDto>> search(@Valid @ParameterObject SearchProductDto searchProductDto) {
		return ResponseEntity.ok(productService.search(searchProductDto).orThrow());
	}


	@GetMapping("{id}")
	public Product getById(@PathVariable("id") Integer id) {

        return productService.findById(id);
	}

	@PostMapping()
	public ResponseEntity<Product> create(@RequestBody CreateProductDto product) {

		return ResponseEntity.ok(productService.create(product).get());
	}

	@PutMapping()
	public ResponseEntity<Product> update( @RequestBody UpdateProductDto updateProductDto) {
		return ResponseEntity.ok(productService.update(updateProductDto).get());
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
	
//	@GetMapping("{id}")
//	public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
//		return ResponseEntity.ok(productService.findById(id));
//	}
////
	@GetMapping("danh-muc/{id}")
	public List<Product> findByCategoryId(@PathVariable("id") Integer id) {
		return productService.findByCategoryId(id);
	}
	
	
}
