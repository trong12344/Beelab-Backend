package com.Beelab.Imp;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.SizeDAO;
import com.Beelab.Entity.Product;
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

	public Size findOneByName(String name) {
		return (Size) cdao.findOneByName(name);
	}

	@Override
	public Size updateSize(Size size) {
		 return cdao.save(size);
	}
//	 @Override
//	    public Page<Size> findAllByPage(int pageNumber, int pageSize) {
//	        Pageable pageable = (Pageable) PageRequest.of(pageNumber - 1, pageSize);
//	        return cdao.findAll(pageable);
//	    }
//	@Override
//	public Size updateSize(int id) {
//		return cdao.save(updateSize(id));
//	
//	}
//	
}
