package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Product;
import com.Beelab.dto.CreateProductDetailDto;
import com.Beelab.dto.ProductDetailDto;
import com.Beelab.Common.HandleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Beelab.Entity.ProductDetail;
public interface ProductDetailServ {
	
	public HandleResponse<List<ProductDetail>> getProductDetailByProductId(Integer cid);

	public HandleResponse<ProductDetail> createProductDetail(CreateProductDetailDto productDetail);
	
}
