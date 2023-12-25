package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Size;

public interface SizeService {
   public Size createSize(Size size);
   
    
   public List<Size> getListSize();
    
   public Size findOneById(int id);
   
   public Size findOneByName(String name);

public Size updateSize(int id, Size size);
    
}
