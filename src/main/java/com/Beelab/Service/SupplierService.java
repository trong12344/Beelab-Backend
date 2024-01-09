package com.Beelab.Service;

import java.util.List;

import com.Beelab.dto.supplierdto.*;
import com.Beelab.Entity.Supplier;

import org.springframework.http.ResponseEntity;

public interface SupplierService {
	public Supplier createSupplier(Supplier supplier);

	public Supplier updateSupplier(int id );

	public Supplier findOneById(int id);

	public Supplier findOneByEmail(String email);

	public Supplier update(Supplier supplier);

	public ResponseEntity<List<SupplierDto>> getListSupplier();

	public Supplier delete(int id);

	PageResponse<Supplier> search(String name, String description, String phoneNumber, String address, int page, int size);
}
