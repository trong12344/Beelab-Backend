package com.Beelab.dto.supplierdto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
@Data
@Builder

public class CreateSupplierDto {
    @NotEmpty(message = "Tên nhà cung cấp không được để trống")
    private String name;
    private String description;
    @Pattern(regexp = "^(\\+84|0)\\d{9,10}$", message = "Số điện thoại không hợp lệ")
    private String phone_number;
    @NotEmpty(message = "Địa chỉ không được để trống")
    private String address;

}
