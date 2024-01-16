package com.Beelab.dto.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class changePasswordDto {
    @NotEmpty(message = "Mật khẩu cũ không được để trống")
    private String oldPassword;
    @Size(min = 4, message = "Mật khẩu phải có ít nhất 4 ký tự")

    private String newPassword;
}
