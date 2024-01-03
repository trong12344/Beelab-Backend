package com.Beelab.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
public class CreateProductDto extends ProductDto{
    @NotNull(message = "Supplier ID không được để trống")
    private Integer supplierId;

    @NotNull(message = "Category ID không được để trống")
    private Integer categoryId;

    @NotEmpty(message = "Tên không được để trống")
    private String name;

    @NotNull(message = "Số lượng không được để trống")
    @PositiveOrZero(message = "Số lượng phải lớn hơn 0")
    private double amount;

    @NotEmpty(message = "Ảnh sản phẩm không được để trống")
    @URL(message = "Ảnh sản phẩm không hợp lệ")
    private String displayImage;

    @NotEmpty(message = "Mô tả không được để trống")
    private String description;

    @Min(value = 0, message = "Giảm giá sản phẩm phải lớn hơn 0")
    @Max(value = 100, message = "Giảm giá sản phẩm phải nhỏ hơn 100")
    private Integer discountPercent;
}
