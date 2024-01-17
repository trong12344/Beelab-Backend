package com.Beelab.API;

import java.util.List;

import com.Beelab.Common.Paginated;
import com.Beelab.dto.productdto.*;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.Beelab.Service.ProductService;



@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductAPI {
	@Autowired
	ProductService productService;
	
	@GetMapping()
	@Secured("CAN_ORDER")
//	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity<Paginated<ProductDto>> getAll(@Valid @ParameterObject getAllProductDto getAllProductDto) {
		return ResponseEntity.ok(productService.findAll(getAllProductDto).orThrow());
	}

	@GetMapping("/search")
	@Secured("CAN_ORDER")
	public ResponseEntity<Paginated<ProductDto>> search(@Valid @ParameterObject SearchProductDto searchProductDto) {
		return ResponseEntity.ok(productService.search(searchProductDto).orThrow());
	}

	@GetMapping("{id}")
	@Secured("CAN_ORDER")
	public Product getById(@PathVariable("id") Integer id) {

        return productService.findById(id);
	}

	@PostMapping()
	@Secured("PRODUCT_MANAGEMENT")
	public ResponseEntity<Product> create(@RequestBody CreateProductDto product) {

		return ResponseEntity.ok(productService.create(product).get());
	}

	@PutMapping()
	@Secured("PRODUCT_MANAGEMENT")
	public ResponseEntity<Product> update( @RequestBody UpdateProductDto updateProductDto) {
		return ResponseEntity.ok(productService.update(updateProductDto).get());
	}

	@DeleteMapping("{id}")
	@Secured("PRODUCT_MANAGEMENT")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
	
//	@GetMapping("{id}")
//	public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
//		return ResponseEntity.ok(productService.findById(id));
//	}
////
	@GetMapping("danh-muc/{id}")
	@Secured("CAN_ORDER")
	public List<Product> findByCategoryId(@PathVariable("id") Integer id) {
		return productService.findByCategoryId(id);
	}
	
	
}
