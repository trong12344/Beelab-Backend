package com.Beelab.Imp;

import java.util.ArrayList;
import java.util.List;

import com.Beelab.dto.supplierdto.*;
import jakarta.persistence.criteria.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.Beelab.DAO.SupplierDAO;
import com.Beelab.Entity.Supplier;
import com.Beelab.Service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	SupplierDAO spdao;
	ModelMapper modelMapper= new ModelMapper();
	SupplierMapper supplierMapper;
	@Override
	public Supplier createSupplier(Supplier supplier) {
		return spdao.save(supplier);
	}
	@Override
	public Supplier updateSupplier(int id ) {
		return spdao.save(updateSupplier(id));
	}
	@Override
	public Supplier findOneById(int id) {
		return spdao.findById(id).get();
	}
	@Override
	public Supplier findOneByEmail(String email) {
		return (Supplier) spdao.findOneByEmail(email);
	}
	@Override
	public Supplier update(Supplier supplier ) {
		return spdao.save(supplier);
	}


	////demo
	@Override
	public ResponseEntity<List<SupplierDto>> getListSupplier() {
		List<Supplier> suppliers = spdao.getListSupplier();
		List<SupplierDto> supplierDtos = suppliers.stream()
				.map(source -> modelMapper.map(source, SupplierDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(supplierDtos);
	}
	@Override
	public Supplier delete(int id){
		Optional<Supplier> existingSupplierOptional = spdao.findById(id);
		if (existingSupplierOptional.isPresent()) {
			Supplier existingSupplier = existingSupplierOptional.get();
			existingSupplier.setStatus(1);
			spdao.save(existingSupplier);
			return existingSupplier;
		} else {
			return null;
		}
	}

	public PageResponse<Supplier> search(String name,
										 String description,
										 String phoneNumber,
										 String address,
										 int page,
										 int size

	){
		Pageable pageable = PageRequest.of(
				page,
				size,
				Sort.by(Sort.Direction.valueOf("DESC"),"name"));
		Specification<Supplier> query = (root, criteriaQuery , criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(name != null){
				predicates.add(criteriaBuilder.equal(root.get("name"), name));
			}
			if(description != null){
				predicates.add(criteriaBuilder.equal(root.get("description"), description));
			}
			if(phoneNumber != null){
				predicates.add(criteriaBuilder.like(root.get("phoneNumber"), phoneNumber));
			}
			if(address != null){
				predicates.add(criteriaBuilder.equal(root.get("address"), address));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
		Page<Supplier> listSupplier = spdao.findAll(query,pageable);
		List<Supplier> result = listSupplier.getContent();
		return PageResponse.<Supplier>builder()
				.totalPages(listSupplier.getTotalPages())
				.pageSize(size)
				.totalElements(listSupplier.getTotalElements())
				.data(result)
				.build();
	}
	public SupplierResponse buildSupplierResponse(Supplier supplier){
		return supplierMapper.toMapSupplierResponse(supplier);
	}

}
