package com.Beelab.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Beelab.Entity.Color;

public interface ColorService {
	
   public Color createColor(Color color);

   public Color updateColor(Color color);

   public List<Color> getListColor();

   public Color findOneById(int id);


}
