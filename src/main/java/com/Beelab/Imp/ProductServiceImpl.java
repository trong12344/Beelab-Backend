package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.ProductDAO;
import com.Beelab.Entity.Product;
<<<<<<< HEAD
import com.Beelab.Entity.ProductDetail;
=======
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
import com.Beelab.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
<<<<<<< HEAD
	public List<Product> findByCategoryId(Integer cid) {
=======
	public List<Product> findByCategoryId(String cid) {
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
		return pdao.findByCategoryId(cid);
	}

	public Product create(Product product) {
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
<<<<<<< HEAD
		pdao.updateStatusToZero();
	}

	@Override
	public List<Product> findBySupplierId(Integer cid) {
		return pdao.findBySupplierId(cid);
	}


	

	
=======
		pdao.deleteById(id);
	}
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
	
}
