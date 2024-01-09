package com.Beelab.dto.userdto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Builder
@Getter
@Setter
public class ChangePasswordDTO<T>{
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
