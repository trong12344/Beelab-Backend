package com.Beelab.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {

	@Id
	int id;
	String name;	
	boolean status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> product;

}
