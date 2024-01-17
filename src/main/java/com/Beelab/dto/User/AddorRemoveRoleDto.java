package com.Beelab.dto.User;

import lombok.Data;

@Data
public class AddorRemoveRoleDto {
    private int userId;
    private String role;
}
