package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Beelab.DAO.CategoryDAO;
import com.Beelab.Entity.Category;
import com.Beelab.Service.CategogyService;
import java.util.Optional;
public class CategoryServiceImpl implements CategogyService {
@Autowired
CategoryDAO cdao ;
	@Override
	public Category createCategogy(Category category) {
		// TODO Auto-generated method stub
		return cdao .save(category);
	}

	@Override
	public Category updateCategogy(int id) {
	     return cdao .save(updateCategogy(id));
	    }


	@Override
	public List<Category> getListCategogy() {
		// TODO Auto-generated method stub
		return cdao .findAll();
	}

	@Override
	public Category findOneById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

	@Override
	public Category findOneByName(String name) {
		// TODO Auto-generated method stub
		return (Category) cdao.findOneByName(name);
	}

}
