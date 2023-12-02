package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Color;

public interface ColorService {
	
   public Color createColor(Color createColorDTO);

   public Color updateColor(Long id, Color updateColorDTO);

   public List<Color> getListColor();

   public Color findOneById(Long id);

   public void update(Color color);
}
