package com.Beelab.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Beelab.Entity.ProductDetail;
public interface ProductDetailServ {
	
	public 	List<ProductDetail>  getProductDetail(Integer cid);
	
}
