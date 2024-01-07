package com.Beelab.API;

import java.util.List;
import java.util.Optional;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Beelab.Entity.Supplier;

import com.Beelab.Service.SupplierService;
@CrossOrigin("*")
@RestController
@RequestMapping("/rest/supplier")
public class SupplierAPI {
	@Autowired
	SupplierService supplierService;


	@GetMapping
	public List<Supplier> getAll() {

		return supplierService.getListSupplier();

	}

	@GetMapping("{id}")
	public Supplier findOneById(@PathVariable("id") int id) {
		return supplierService.findOneById(id);
	}

	@GetMapping("/email/{email}")
	public Supplier findOneByEmail(@PathVariable String email) {
		return supplierService.findOneByEmail(email);
	}

	@PostMapping
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierService.createSupplier(supplier);
	}

	@PutMapping("{id}")
	public Supplier updateSupplier(@PathVariable("id") Integer id, @RequestBody Supplier supplier) {
		return supplierService.update(supplier);
	}

	@PutMapping
	public Supplier update(@RequestBody Supplier supplier) {
		return supplierService.update(supplier);
	}


	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {

		 supplierService.delete(id);
	}}
