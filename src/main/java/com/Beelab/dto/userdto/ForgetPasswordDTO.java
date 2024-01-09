package com.Beelab.dto.userdto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForgetPasswordDTO<T>{
    private String email;
}
