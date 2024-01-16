package com.Beelab.API;

import java.util.List;

import com.Beelab.DTO.CategoryDTO;
import com.Beelab.Entity.Color;
import com.Beelab.Entity.Size;
import com.Beelab.Response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Beelab.Entity.Category;
import com.Beelab.Service.CategogyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryAPI {
@Autowired
CategogyService categogyService;
@GetMapping("/tendanhmuc/{name}")
public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
	List<Category> categories = categogyService.findByName(name);
	if (!categories.isEmpty()) {
		Category category = categories.get(0);
		return ResponseEntity.ok(category);
	} else {
		return ResponseEntity.notFound().build();
	}
}
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getCategoryList() {
		return ResponseEntity.ok(categogyService.getCategoryList().getBody());
	}
	@GetMapping("/id/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categogyService.findOneById(id);
	}

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categogyService.createCategogy(category);
	}
//
	@PutMapping("{id}")
	public Category updateCategory(@RequestBody Category category) {
		return categogyService.updateCategory(category);
	}
//
	@DeleteMapping("/{id}")
	public ResponseEntity<java.lang.Object> deleteCategoryById(@PathVariable int id) {
		Category deletedCategory = categogyService.deleteCategoryById(id);
		if (deletedCategory != null) {
			return ResponseEntity.ok("Category  ID " + id + " delete thành công.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with ID " + id);
		}
	}
	@GetMapping("/page/categories")
	public ResponseEntity<Page<Category>> getCategories(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size) {

		Page<Category> categories = categogyService.getAllCategories(page, size);
		return ResponseEntity.ok(categories);
	}
	@GetMapping("/search")
	public ResponseEntity<PageResponse<Category>> getListCategory(
			@RequestParam(value = "name" , required = false)  String name,
			@RequestParam(value = "description" , required = false) String description,
			@RequestParam(value = "product" ,required = false) String product,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size
			//@RequestParam(value = "status", required = false) SupplierStatus status
	) {
		return ResponseEntity.ok(categogyService.search(name,description,product,page,size));
	}
}
