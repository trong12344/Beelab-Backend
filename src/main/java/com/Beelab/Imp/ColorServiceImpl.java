package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;

import com.Beelab.DAO.ColorDAO;
import com.Beelab.Entity.Color;
import com.Beelab.Service.ColorService;

public abstract class ColorServiceImpl implements ColorService {
@Autowired
ColorDAO cdao;
	@Override
	public Color createColor(Color color) {
		// TODO Auto-generated method stub
		return cdao.save(color);
	}

	public Color updateColor(Color color) {
		// TODO Auto-generated method stub
		return cdao .save(color);
	}

	@Override
	public List<Color> getListColor() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public Color findOneById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

}
