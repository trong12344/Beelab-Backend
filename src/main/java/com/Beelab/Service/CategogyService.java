package com.Beelab.Service;

import java.util.List;

import com.Beelab.DTO.CategoryDTO;
import com.Beelab.Entity.Category;
import com.Beelab.Response.PageResponse;
import org.springframework.http.ResponseEntity;

public interface CategogyService {
	public Category createCategogy(Category category);

	public Category deleteCategoryById(int id);

	public ResponseEntity<List<CategoryDTO>> getCategoryList();
	//public List<Category> getCategoryList();

	public Category findOneById(int id);

	public Category findOneByName(String name);

	public Category updateCategory(Category Category);

public	PageResponse<Category> search(String name, String description, String product, int page, int size);

}
