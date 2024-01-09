package com.Beelab.Service;

import com.Beelab.Entity.ProductImage;
import com.Beelab.dto.createImageDto;
import com.Beelab.Common.HandleResponse;

import java.util.List;

public interface ImageService {
    public HandleResponse<ProductImage> create(createImageDto createImageDto);

}
