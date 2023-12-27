package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.ColorDAO;
import com.Beelab.Entity.Color;
import com.Beelab.Service.ColorService;
@Service
public class ColorServiceImpl implements ColorService {
@Autowired
ColorDAO cdao;
	@Override
	public Color createColor(Color color) {
		// TODO Auto-generated method stub
		return cdao.save(color);
	}

	public Color updateColor(Color color) {
		return cdao .save(color);
	}

	@Override
	public List<Color> getListColor() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}
       
	@Override
	public Color findOneById(int id) {
		return cdao.findById(id).get();
	}

}
