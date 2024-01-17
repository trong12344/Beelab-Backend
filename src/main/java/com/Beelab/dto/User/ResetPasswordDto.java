package com.Beelab.dto.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ResetPasswordDto {
    private String token;
    @Length(min = 8, message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String newPassword;

}
