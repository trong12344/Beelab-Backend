package com.Beelab.Entity;

import java.io.Serializable;
import java.util.List;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
=======
import jakarta.persistence.Entity;
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
=======

>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category implements Serializable {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;

	 @Column(columnDefinition = "VARCHAR DEFAULT ''")
	 private String name;

	 @Column(columnDefinition = "VARCHAR DEFAULT ''")
	 private String description;

	 @Column(columnDefinition = "INT DEFAULT 0")
	 private int status;	
	 
	 
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> product;
=======
@Table(name = "cart")
public class Category implements Serializable {

	@Id
	String id;
	String name;
	Double amount;
	int quantity;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8

}
