package com.Beelab.Imp;

import java.util.List;
import java.util.Optional;

import com.Beelab.DAO.ColorDAO;
import com.Beelab.DAO.ProductDAO;
import com.Beelab.DAO.SizeDAO;
import com.Beelab.Entity.Color;
import com.Beelab.Entity.Product;
import com.Beelab.Entity.Size;
import com.Beelab.dto.CreateProductDetailDto;
import com.Beelab.dto.ProductDetailDto;
import com.Beelab.Common.HandleResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Beelab.DAO.ProductDetailDAO;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.Service.ProductDetailServ;
import org.springframework.ui.ModelMap;


@Service
public class ProductDetailServiceImpl implements ProductDetailServ{
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	ProductDetailDAO pddao;

	@Autowired
	ProductDAO pdao;

	@Autowired
	ColorDAO cdao;

	@Autowired
	SizeDAO sdao;


	@Override
	public HandleResponse<List<ProductDetail>> getProductDetailByProductId(Integer cid) {
		List<ProductDetail> productDetails = pddao.getProductDetailByProductId(cid);
		if (productDetails.isEmpty()){
			return HandleResponse.error("Không tìm thấy sản phảm");
		}
		return HandleResponse.ok(productDetails);
	}

	@Override
    public HandleResponse<ProductDetail> createProductDetail(CreateProductDetailDto createProductDetailDto) {
		Optional<Product> product = pdao.findById(createProductDetailDto.getProductId());
		if(product.isEmpty()){
			return HandleResponse.error("Không tìm thấy sản phẩm");
		}
		Optional<Color> color = cdao.findById(createProductDetailDto.getColorId());
		Optional<Size> size = sdao.findById(createProductDetailDto.getSize());
		Optional<ProductDetail> productDetail = pddao.findFirstByProductIdAndColorIdAndSize(createProductDetailDto.getProductId(), createProductDetailDto.getColorId(), createProductDetailDto.getSize());
		if(productDetail.isPresent()){
			return HandleResponse.error("Sản phẩm đã tồn tại");
		}
		ProductDetail newDetail = ProductDetail.builder()
				.product(product.get())
				.color(color.get())
				.size(size.get())
				.quantity(createProductDetailDto.getQuantity())
				.build();
		pddao.save(newDetail);
        return HandleResponse.ok(newDetail);
    }




}
