package com.Beelab.dto.reportDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UpdateSupplierDto {
    @Min(value = 1, message = "Mã nhà cung cấp không hợp lệ")
    private int id;
    @NotEmpty(message = "Tên nhà cung cấp không được để trống")
    private String name;
    private String description;
    @Pattern(regexp = "^(\\+84|0)\\d{9,10}$", message = "Số điện thoại không hợp lệ")
    private String phone_number;
    @NotEmpty(message = "Địa chỉ không được để trống")
    private String address;
}
