package com.Beelab.dto;


import com.Beelab.Entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private int productId;
    private String name;
    private int supplierId;
    private Category category;
    private String code;
    private double amount;
    private List<ProductDetailDto> productDetail;
}
