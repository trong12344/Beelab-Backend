package com.Beelab.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.Beelab.Entity.Category;
import com.Beelab.Service.CategogyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryAPI {
@Autowired
CategogyService categogyService;
@GetMapping
public List<Category> getAllCategories() {
	return categogyService.getListCategogy();
}
//	@Autowired
//	CategogyService categoryService;
//
//	@GetMapping
//	public List<Category> getAllCategories() {
//		return categoryService.getListCategogy();
//	}
//
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categogyService.findOneById(id);
	}
//
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
}
