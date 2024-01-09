package com.Beelab.dto.productdto;


import com.Beelab.Entity.Category;
import com.Beelab.Entity.Supplier;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int productId;
    private String name;
    private String displayImage;
    private Supplier supplier;
    private Category category;
    private String code;
    private Integer discountPercent;
    private double amount;
    private List<ProductDetailDto> productDetail;
}
