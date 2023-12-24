package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Color;

public interface ColorService {
	
   public Color createColor(Color color);

   public Color updateColor(Color color);

   public List<Color> getListColor();

   public Color findOneById(int id);


}
