package com.Beelab.dto.productdto;

import com.Beelab.Entity.Size;
import com.Beelab.Entity.Color;
import lombok.Data;

@Data
public class ProductDetailDto {

    private int id;
    private Size size;
    private Color color;


}
