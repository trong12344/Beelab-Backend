package com.Beelab.Service;

import java.util.List;

import com.Beelab.Common.PageResponse;

import com.Beelab.Entity.Product;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.dto.CreateProductDetailDto;
import com.Beelab.dto.CreateProductDto;
import com.Beelab.dto.ProductDto;
import com.Beelab.dto.UpdateProductDto;
import com.shop.clothing.common.Cqrs.HandleResponse;

public interface ProductService {
	public PageResponse<Product> search(String name, int CategoryId,int size );

	public List<ProductDto> findAll();

	public Product findById(Integer id);

	public List<Product> findByCategoryId(Integer cid);

	public Product create(CreateProductDto product);

	public ProductDetail createProductDetail(CreateProductDetailDto createProductDetailDtoct);

	public HandleResponse<Void> update(UpdateProductDto product);

	public void delete(Integer id);
	
	public List<Product> findBySupplierId(Integer cid);
	
	
}
