package com.Beelab.dto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto product(ProductDto productDto);
}
