package com.Beelab.dto.supplierdto;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class SupplierDto <T>{
    private int id;
    private String name;
    private String description;
    private String phone_number;
    private String address;
    private int status;
}
