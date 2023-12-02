package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Beelab.DAO.ProductDetailDAO;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.Service.ProductDetailServ;


@Service
public class ProductDetailServiceImpl implements ProductDetailServ{
	@Autowired
	ProductDetailDAO pddao;

	@Override
	public List<ProductDetail>  getProductDetail(Integer cid) {
		return pddao.getProductDetail(cid);
	}


	
	
	
	
}
