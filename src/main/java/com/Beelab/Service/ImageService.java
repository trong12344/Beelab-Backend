package com.Beelab.Service;

import com.Beelab.Entity.ProductImage;
import com.Beelab.dto.productdto.createImageDto;
import com.Beelab.Common.HandleResponse;

public interface ImageService {
    public HandleResponse<ProductImage> create(createImageDto createImageDto);

}
