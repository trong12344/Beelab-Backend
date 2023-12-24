package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

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
=======
import org.springframework.stereotype.Service;

import com.Beelab.DAO.CategoryDAO;
import com.Beelab.Entity.Category;
import com.Beelab.Service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Category findById(String id) {
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
		return cdao.findById(id).get();
	}

	@Override
<<<<<<< HEAD
	public Category findOneByName(String name) {
		// TODO Auto-generated method stub
		return (Category) cdao.findOneByName(name);
=======
	public Category create(Category category) {
		return cdao.save(category);
	}

	@Override
	public Category update(Category category) {
		return cdao.save(category);
	}

	@Override
	public void delete(String id) {
		cdao.deleteById(id);
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
	}

}
