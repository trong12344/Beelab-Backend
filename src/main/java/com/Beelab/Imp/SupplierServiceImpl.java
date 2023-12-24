package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Beelab.DAO.SupplierDAO;
import com.Beelab.Entity.Supplier;
import com.Beelab.Service.SupplierService;

public class SupplierServiceImpl implements SupplierService {
@Autowired
SupplierDAO  spdao;
	@Override
	public Supplier createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return spdao  .save(supplier) ;
	}

	@Override
	public Supplier updateSupplier(int id) {
		// TODO Auto-generated method stub
		return spdao .save(updateSupplier(id));
	}

	@Override
	public Supplier findOneById(int id) {
		// TODO Auto-generated method stub
		return spdao .findById(id).get();
	}

	@Override
	public Supplier findOneByEmail(String email) {
		// TODO Auto-generated method stub
		return (Supplier) spdao.findOneByEmail(email);
	}

	@Override
	public Supplier update(Supplier supplier) {
		// TODO Auto-generated method stub
		return spdao .save(supplier);
	}

	@Override
	public List<Supplier> getListSupplier() {
		// TODO Auto-generated method stub
		return spdao .findAll();
	}

}
