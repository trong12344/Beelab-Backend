package com.Beelab.dto.userdto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO <T>{
    private int id;
    private String full_name;
    private String email;
    private String phone_number;
    private Date birthday;
    //Thiếu Address
    //Thiếu Status
}
