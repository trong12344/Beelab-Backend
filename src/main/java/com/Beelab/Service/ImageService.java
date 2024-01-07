package com.Beelab.Service;

import com.Beelab.Entity.ProductImage;
import com.Beelab.dto.createImageDto;
import com.shop.clothing.common.Cqrs.HandleResponse;

import java.util.List;

public interface ImageService {
    public HandleResponse<ProductImage> create(createImageDto createImageDto);

}
