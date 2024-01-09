package com.Beelab.dto.userdto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResetPasswordDTO<T>{
    private String email;
    private String verificationCode;
    private String newPassword;
    private String confirmPassword;
}
