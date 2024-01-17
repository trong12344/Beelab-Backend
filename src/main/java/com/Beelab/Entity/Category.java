package com.Beelab.Entity;

import java.io.Serializable;
import java.util.List;

import com.Beelab.Common.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category implements Serializable  {

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

}
