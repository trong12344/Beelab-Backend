//package com.Beelab.Imp;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Beelab.DAO.ProductDAO;
//import com.Beelab.Entity.Product;
//import com.Beelab.Service.ProductService;
//
//@Service
//public class ProductServiceImpl implements ProductService{
//	@Autowired
//	ProductDAO pdao;
//
//	@Override
//	public List<Product> findAll() {
//		return pdao.findAll();
//	}
//
//	@Override
//	public Product findById(Integer id) {
//		return pdao.findById(id).get();
//	}
//
//	@Override
//	public List<Product> findByCategoryId(String cid) {
//		return pdao.findByCategoryId(cid);
//	}
//
//	public Product create(Product product) {
//		return pdao.save(product);
//	}
//
//	@Override
//	public Product update(Product product) {
//		return pdao.save(product);
//	}
//
//	@Override
//	public void delete(Integer id) {
//		pdao.deleteById(id);
//	}
//	
//}
