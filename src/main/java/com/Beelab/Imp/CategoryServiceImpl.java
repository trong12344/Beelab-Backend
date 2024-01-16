package com.Beelab.Imp;

import java.util.ArrayList;
import java.util.List;

import com.Beelab.DTO.CategoryDTO;
import com.Beelab.Response.PageResponse;
import jakarta.persistence.criteria.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.CategoryDAO;
import com.Beelab.Entity.Category;
import com.Beelab.Service.CategogyService;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategogyService {
	@Autowired
	CategoryDAO cdao;
	ModelMapper modelMapper= new ModelMapper();
	@Override
	public Category createCategogy(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}
	
	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
		
	}




	@Override
	public ResponseEntity<List<CategoryDTO>> getCategoryList() {
		List<Category> categories = cdao.getListCategory();
		List<CategoryDTO> categoriesdto = categories.stream()
				.map(source -> modelMapper.map(source,CategoryDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(categoriesdto);
	}

	@Override
	public Category findOneById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}
	@Override
	public List<Category> findByName(String name){
			return cdao.findByName(name);
	}
	@Override
	public Page<Category> getAllCategories(int page, int size) {
		return cdao.findAll(PageRequest.of(page, size));
	}
//	@Override
//	public Categor findOneByName(String name) {
//		return (Category) cdao.findOneByName(name);
//	}
	@Override
	public Category deleteCategoryById(int id) {
		Optional<Category> existingCategoryOptional = cdao.findById(id);
		if (existingCategoryOptional.isPresent()) {
			Category existingCategory = existingCategoryOptional.get();
			cdao.deleteById(id);
			return existingCategory;
		} else {
			return null;
		}
	}
	@Override
	public PageResponse<Category> search(String name,
										 String description,
										 String product,
										 int page,
										 int size

	){
		Pageable pageable = PageRequest.of(
				page,
				size,
				Sort.by(Sort.Direction.valueOf("DESC"),"name"));
		Specification<Category> query = (root, criteriaQuery , criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(name != null){
				//predicates.add(criteriaBuilder.equal(root.get("name"), name));
				predicates.add(criteriaBuilder.equal(root.get("name"), name));

			}
			if(description != null){
				predicates.add(criteriaBuilder.equal(root.get("description"), description));
			}
			if(product != null){
				predicates.add(criteriaBuilder.like(root.get("product"), product));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
		Page<Category> listCategory = cdao.findAll(query,pageable);
		List<Category> result = listCategory.getContent();
		return PageResponse.<Category>builder()
				.totalPages(listCategory.getTotalPages())
				.pageSize(size)
				.totalElements(listCategory.getTotalElements())
				.data(result)
				.build();
	}


	
}
