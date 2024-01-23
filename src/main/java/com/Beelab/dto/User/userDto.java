package com.Beelab.dto.User;

import com.Beelab.Entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class userDto {
    private int id;
    private String fullname;
    private List<Role> role;
    private String username;
    private String password;
}
