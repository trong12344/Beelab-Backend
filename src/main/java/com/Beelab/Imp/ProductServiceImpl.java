package com.Beelab.Imp;

import java.util.List;
import java.util.Optional;

import com.Beelab.Common.Paginated;
import com.Beelab.DAO.CategoryDAO;
import com.Beelab.DAO.SupplierDAO;
import com.Beelab.Entity.Category;
import com.Beelab.Entity.Supplier;
import com.Beelab.dto.*;
import com.shop.clothing.common.Cqrs.HandleResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.Beelab.DAO.ProductDAO;
import com.Beelab.Entity.Product;
import com.Beelab.Service.ProductService;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ProductServiceImpl implements ProductService{

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	ProductDAO pdao;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	SupplierDAO sdao;


	@Override
	@Transactional(readOnly = true)
	public HandleResponse<Paginated<ProductDto>> search(SearchProductDto searchProductDto) {
		Page<Product> product = pdao.searchAllProducts(searchProductDto.getKeyword(), searchProductDto.getCategoryIds(), searchProductDto.getMinPrice(), searchProductDto.getMaxPrice(), searchProductDto.getColorIds(), searchProductDto.getSizes(), searchProductDto.getPageable("product.createdDate"));
		Page<ProductDto> productDto = product.map(Product -> {
			return modelMapper.map(Product, ProductDto.class);
		});
		return HandleResponse.ok(Paginated.of(productDto));
	}


	@Override
	@Transactional(readOnly = true)
	public HandleResponse<Paginated<Product>> findAll(getAllProductDto getAllProductDto) {
		String sortField = getAllProductDto.getSortField();
		if (sortField.isBlank()) {
			sortField = "created_date";
		}
		Page<Product> product = pdao.GetAll(getAllProductDto.getPageable(sortField));

//		Page<ProductDto> productDto = product.map(Product -> {
//			return modelMapper.map(Product, ProductDto.class);
//		});
		return HandleResponse.ok(Paginated.of(product));
	}

	@Override
	public Product findById(Integer id) {

		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(Integer cid) {
		return pdao.findByCategoryId(cid);
	}

	@Override
	public HandleResponse<Product> create(CreateProductDto createProductDto) {
		Optional<Category> category = cdao.findById(createProductDto.getCategoryId());

		Optional<Supplier> supplier = sdao.findById(createProductDto.getSupplierId());
		Product product = Product.builder()
				.category(category.get())
				.name(createProductDto.getName())
				.supplierId(supplier.get())
				.displayImage(createProductDto.getDisplayImage())
				.amount(createProductDto.getAmount())
				.description(createProductDto.getDescription())
				.discountPercent(createProductDto.getDiscountPercent())
				.build();
		pdao.save(product);
		return HandleResponse.ok(product);
	}

//	@Override
//	public ProductDetail createProductDetail(CreateProductDetailDto createProductDetailDtoct) {
//		return null;
//	}

	@Override
	public HandleResponse<Product> update(UpdateProductDto updateProductDto) {
		Optional<Product> Exitproduct = pdao.findById(updateProductDto.getId());
		if(Exitproduct.isEmpty()){
			return HandleResponse.error("Không tìm thấy sản phẩm");
		}
		Product product = Exitproduct.get();
		product.setName(updateProductDto.getName());
		product.setAmount(updateProductDto.getAmount());
		product.setDescription(updateProductDto.getDescription());
		product.setDisplayImage(updateProductDto.getDisplayImage());
		product.setDiscountPercent(updateProductDto.getDiscountPercent());
		pdao.save(product);
		return HandleResponse.ok(product);
	}

	@Override
	public void delete(Integer id) {
		pdao.deleteById(id);
	}

	public Product create(Product product) {

		return pdao.save(product);
	}


	public List<Product> findBySupplierId(Integer cid) {
		return pdao.findBySupplierId(cid);
	}


	

	
	
}
