package com.Beelab.Service;

import java.util.List;

import com.Beelab.dto.productdto.CreateProductDetailDto;
import com.Beelab.Common.HandleResponse;

import com.Beelab.Entity.ProductDetail;
public interface ProductDetailServ {
	
	public HandleResponse<List<ProductDetail>> getProductDetailByProductId(Integer cid);

	public HandleResponse<ProductDetail> createProductDetail(CreateProductDetailDto productDetail);
	
}
