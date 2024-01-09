package com.Beelab.dto.cartDto;

import com.Beelab.Common.IRequest;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AddToCartDto {
    private int userId;
    private int productDetailId;
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private int quantity;
}
