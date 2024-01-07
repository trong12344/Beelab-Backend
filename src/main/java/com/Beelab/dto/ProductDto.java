package com.Beelab.dto;


import com.Beelab.Common.IRequest;
import com.Beelab.Common.Paginated;
import com.Beelab.Common.PaginationRequest;
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
