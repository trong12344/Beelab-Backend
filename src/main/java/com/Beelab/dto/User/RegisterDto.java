package com.Beelab.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
@Data
public class RegisterDto {
    @NotEmpty(message = "Họ và tên không được để trống")
    private String fullName;
    @NotEmpty(message = "Email không được để trống")
    @Email

//    private int phoneNumber;
    private String email;
    @NotEmpty(message = "Mật khẩu không được để trống")
    @Length(min = 8,message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String rawPassword;
}
