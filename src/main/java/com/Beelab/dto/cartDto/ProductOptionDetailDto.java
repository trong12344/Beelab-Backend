//package com.Beelab.cartDto;
//
//import com.Beelab.dto.productdto.ProductDetailDto;
//import com.Beelab.dto.productdto.ProductDto;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class ProductOptionDetailDto extends ProductDetailDto {
//    private ProductDto product;
//    private int quantity=0;
//
//    public int getFinalPrice() {
//        return (int) (this.getProduct().getAmount() * (100.0 - this.getProduct().getDiscountPercent()) / 100);
//    }
//
//    public String getFinalPriceDisplay() {
//        return String.format("%,dđ", getFinalPrice());
//    }
//}
