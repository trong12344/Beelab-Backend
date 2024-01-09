package com.Beelab.dto.supplierdto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collections;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString()

public class SupplierResponse {
    private int id;
    private String name;
    private String description;
    private String phone_number;
    private String address;
    private Integer status;
}
