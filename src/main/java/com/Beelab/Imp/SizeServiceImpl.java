package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Beelab.DAO.SizeDAO;
import com.Beelab.Entity.Size;
import com.Beelab.Service.SizeService;

public abstract class SizeServiceImpl implements SizeService {
@Autowired
SizeDAO cdao;
	@Override
	public Size createSize(Size size) {
		// TODO Auto-generated method stub
		return cdao .save(size); 
	}

	
	public Size updateSize(Integer id) {
		// TODO Auto-generated method stub
		return cdao.save(updateSize(id));
	}

	public List<Size> getListSize() {
		// TODO Auto-generated method stub
		return cdao .findAll();
	}

	@Override
	public Size findOneById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
		
	}

	public Size findOneByName(String name) {
		// TODO Auto-generated method 
		return   (Size) cdao.findOneByName(name);
	}

}
