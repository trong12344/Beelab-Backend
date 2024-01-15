package com.Beelab.API;

import java.util.List;
import java.util.Optional;


import java.util.List;

import com.Beelab.dto.supplierdto.*;

import com.Beelab.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Beelab.Entity.Supplier;
import com.Beelab.DAO.SupplierDAO;
import com.Beelab.Service.SupplierService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/supplier")
public class SupplierAPI {
	@Autowired
	private SupplierService supplierService;
	private SupplierDAO spDao;

	@GetMapping("/search")
	public ResponseEntity<PageResponse<Supplier>> getListSupplier(
			@RequestParam(value = "name" , required = false)  String name,
			@RequestParam(value = "description" , required = false) String description,
			@RequestParam(value = "phoneNumber" ,required = false) String phoneNumber,
			@RequestParam(value = "address" ,required = false) String address,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size
			///@RequestParam(value = "status", required = false) SupplierStatus status
	) {
		return ResponseEntity.ok(supplierService.search(name,description,phoneNumber,address,page,size));
	}
	@GetMapping
	public ResponseEntity<List<SupplierDto>> getListSupplier() {
		return ResponseEntity.ok(supplierService.getListSupplier().getBody());
	}
	@GetMapping("/{id}/detail")
	public ResponseEntity<Supplier> findOneById(@PathVariable("id") int id) {
		return ResponseEntity.ok(supplierService.findOneById(id));
	}

	@GetMapping("/findemail/{email}")////@requestbody
	public ResponseEntity<Supplier> findOneByEmail(@RequestBody String email) {
		return  ResponseEntity.ok (supplierService.findOneByEmail(email));
	}
	@PostMapping
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierService.createSupplier(supplier);
	}
	@PutMapping("/{id}/update")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") Integer id, @RequestBody Supplier supplier) {
		return ResponseEntity.ok(supplierService.update(supplier));
	}
	@PutMapping
	public ResponseEntity<Supplier> update(@RequestBody Supplier supplier) {
		return ResponseEntity.ok (supplierService.update(supplier));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		Supplier deletedSupplier = supplierService.delete(id);

		if (deletedSupplier != null) {
			return ResponseEntity.ok(deletedSupplier);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

