package com.Beelab.Imp;

import com.Beelab.DAO.ImageDAO;
import com.Beelab.DAO.ProductDAO;
import com.Beelab.DAO.ProductDetailDAO;
import com.Beelab.Entity.Product;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.Entity.ProductImage;
import com.Beelab.Service.ImageService;
import com.Beelab.Service.ProductService;
import com.Beelab.dto.createImageDto;
import com.shop.clothing.common.Cqrs.HandleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ProductDetailDAO pddao;
    @Autowired
    ImageDAO idao;
    @Autowired
    ProductDAO pdao;

    @Override
    public HandleResponse<ProductImage> create(createImageDto createImageDto) {
        Optional<ProductDetail> productDetail = pddao.findFirstByProductIdAndColorId(createImageDto.getProductId(), createImageDto.getColorId());
        if(productDetail.isEmpty() ){
            return HandleResponse.error("Sản phẩm không tồn tại");
        }
        ProductImage productImageBuilder = ProductImage.builder()
                .product(productDetail.get().getProduct())
                .forColor(productDetail.get().getColor())
                .url(createImageDto.getUrl())
                .build();
        idao.save(productImageBuilder);
        return HandleResponse.ok(productImageBuilder);
    }

}
