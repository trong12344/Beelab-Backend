package com.Beelab.dto.orderdto;

import com.Beelab.dto.productdto.ProductDetailDto;
import lombok.Data;

@Data
public class OrderDetailDto {
    private String orderId;
    private int productOptionId;
    private int quantity;
    private double price;
    private ProductDetailDto productOption;

    public int getTotalPrice() {
        return (int) (quantity * price);
    }
}
