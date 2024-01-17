package com.Beelab.Imp;

import java.util.ArrayList;
import java.util.List;

import com.Beelab.Entity.Category;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.SizeDAO;
import com.Beelab.Entity.Size;
import com.Beelab.Service.SizeService;
@Service
public  class SizeServiceImpl implements SizeService {
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
		return cdao .findAll();
	}

	@Override
	public Size findOneById(int id) {
		return cdao.findById(id).get();

	}

	@Override
	public Size findOneByName(String name) {
		return cdao.findOneByName(name);
	}

	@Override
	public List<Size> findByName(String name) {
		return cdao.findByName(name);
	}


	@Override
	public Size updateSize(Size size) {
		return cdao.save(size);
	}


}