package com.Beelab.dto.cartDto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class updateCartDto {
    private int productDetailId;
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private int newQuantity;
}
