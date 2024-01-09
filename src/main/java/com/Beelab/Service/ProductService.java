package com.Beelab.Service;

import java.util.List;

import com.Beelab.Common.HandleResponse;
import com.Beelab.Common.PageResponse;

import com.Beelab.Common.Paginated;
import com.Beelab.Entity.Product;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.dto.CreateProductDetailDto;
import com.Beelab.dto.CreateProductDto;
import com.Beelab.dto.ProductDto;
import com.Beelab.dto.*;

public interface ProductService {
	public HandleResponse<Paginated<ProductDto>> search(SearchProductDto searchProductDto);

	public HandleResponse<Paginated<Product>>  findAll(getAllProductDto dto);

	public Product findById(Integer id);

	public List<Product> findByCategoryId(Integer cid);

	public HandleResponse<Product> create(CreateProductDto product);

//	public ProductDetail createProductDetail(CreateProductDetailDto createProductDetailDtoct);

	public HandleResponse<Product> update(UpdateProductDto product);

	public void delete(Integer id);
	
//	public List<Product> findBySupplierId(Integer cid);
	
	
}
