package com.Beelab.dto.productdto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductDetailDto {
    @Min(value = 1, message = "Sản phẩm không hợp lệ")
    @NotNull(message = "Sản phẩm không được để trống")
    private Integer productId;
    @NotNull(message = "Màu không được để trống")
    @NotEmpty(message = "Màu không được để trống")
    private Integer colorId;
    @NotEmpty(message = "Size không được để trống")
    @NotNull(message = "Size không được để trống")
    private Integer size;
    private  Integer quantity;


}
