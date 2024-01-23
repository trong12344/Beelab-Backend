package com.Beelab.dto.User;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileDto {
    @NotBlank(message = "Họ không được để trống")
    private String fullName;
    @Email(message = "Email không hợp lệ")
    private String email;
    @Size(min = 10, max = 100, message = "Địa chỉ không hợp lệ")
    private String address;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Số điện thoại không hợp lệ")
    private int phoneNumber;

}
