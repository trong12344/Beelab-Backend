package com.Beelab.Service;

import java.util.List;

import com.Beelab.DTO.CategoryDTO;
import com.Beelab.Entity.Category;
import com.Beelab.Response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface CategogyService {
	public Category createCategogy(Category category);

	public Category deleteCategoryById(int id);

    public	Page<Category> getAllCategories(int page, int size);
	public ResponseEntity<List<CategoryDTO>> getCategoryList();

	public Category findOneById(int id);

	List<Category> findByName(String name);

	public Category updateCategory(Category Category);

	public	PageResponse<Category> search(String name, String description, String product, int page, int size);

}
