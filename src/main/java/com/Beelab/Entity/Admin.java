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
@Table(name = "admin")
public class Admin implements Serializable {

	@Id
	private String id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	List<Authority> authorities;
}