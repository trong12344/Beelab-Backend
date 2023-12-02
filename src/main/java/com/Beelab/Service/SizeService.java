package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Size;

public interface SizeService {
    Size createSize(Size createSizeDTO);
    
    Size updateSize(int id, Size updateSizeDTO);
    
    List<Size> getListSize(String keySearch, int status);
    
    Size findOneById(int id);
    
    Size update(Size size);
}
