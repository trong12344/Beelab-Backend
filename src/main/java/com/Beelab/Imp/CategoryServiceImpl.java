package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.PageRequest;

import com.Beelab.DAO.CategoryDAO;
import com.Beelab.Entity.Category;
import com.Beelab.Service.CategogyService;
import java.util.Optional;

public class CategoryServiceImpl implements CategogyService {
	@Autowired
	CategoryDAO cdao;

	@Override
	public Category createCategogy(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}
	
	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
		
	}

	@Override
	public List<Category> getListCategogy() {
		return cdao.findAll();
	}

	@Override
	public Category findOneById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

	@Override
	public Category findOneByName(String name) {
		return (Category) cdao.findOneByName(name);
	}

	@Override
	public Category deleteCategoryById(int id) {
		Optional<Category> existingCategoryOptional = cdao.findById(id);
		if (existingCategoryOptional.isPresent()) {
			Category existingCategory = existingCategoryOptional.get();
			cdao.deleteById(id);
			return existingCategory;
		} else {
			return null;
		}
	}

//	 @Override
//	    public List<Category> getCategoriesAfterId(int lastCategoryId, int pageSize) {
//	        return cdao.findCategoriesByIdGreaterThan(lastCategoryId, PageRequest.of(0, pageSize));
//	    }

	
}
