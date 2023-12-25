package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Category;

public interface CategogyService {
	public Category createCategogy(Category category);

	public Category deleteCategoryById(int id);

	public List<Category> getListCategogy();

	public Category findOneById(int id);

	public Category findOneByName(String name);

	public Category updateCategory(Category Category);

	//public List<Category> getCategoriesAfterId(int lastCategoryId, int pageSize);

}
