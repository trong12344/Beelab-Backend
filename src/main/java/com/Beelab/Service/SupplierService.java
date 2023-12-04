package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Supplier;

public interface SupplierService {
	 	public Supplier createSupplier(Supplier supplier);

	    public Supplier updateSupplier(int id);

	    public Supplier findOneById(int id);

	    public Supplier findOneByEmail(String email);

	    public Supplier update(Supplier supplier);

	    public List<Supplier> getListSupplier();

}
