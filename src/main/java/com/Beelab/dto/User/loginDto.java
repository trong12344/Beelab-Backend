package com.Beelab.dto.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class loginDto {
    private String username;
    private String password;
}
