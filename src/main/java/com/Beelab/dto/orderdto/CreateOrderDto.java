package com.Beelab.dto.orderdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    @NotEmpty(message = "Cần chọn sản phẩm")
    public List<OrderItem> orderItems;
    @NotEmpty(message = "Cần nhập tên khách hàng")
    private String customerName;
    @NotEmpty(message = "Cần nhập địa chỉ")
    private String address;
    @NotEmpty(message = "Cần nhập số điện thoại")
    @Pattern(regexp = "^(0|\\+84)\\d{9,11}$", message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;
    @Email(message = "Email không đúng định dạng")
    @NotEmpty(message = "Cần nhập email")
    private String email;

}
