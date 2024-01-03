package com.Beelab.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class createImageDto {
    @NotNull(message = "Đường dẫn ảnh không được để trống")
    private String url;
    @NotNull(message = "Màu không được để trống")
    @NotEmpty(message = "Màu không được để trống")
    private Integer colorId;
    @Min(value = 1, message = "Sản phẩm không hợp lệ")
    @NotNull(message = "Sản phẩm không được để trống")
    private Integer productId;
}
