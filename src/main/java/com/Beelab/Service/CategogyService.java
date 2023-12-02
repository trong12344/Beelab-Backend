package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Category;



public interface CategogyService {
	   public Category createCategogy(Category category);
	    
	   public Category updateCategogy(int id);
	    
	   public List<Category> getListCategogy();
	    
	   public Category findOneById(int id);
	   
	   public Category findOneByName(String name);
}
