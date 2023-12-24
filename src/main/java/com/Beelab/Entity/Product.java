package com.Beelab.Entity;

<<<<<<< HEAD
=======
import java.io.Serializable;
import java.util.Date;
import java.util.List;
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
<<<<<<< HEAD
import lombok.Data;

import java.util.Date;
import java.util.List;
import com.Beelab.Entity.ProductDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
=======
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8

@SuppressWarnings("serial")
@Data
@Entity
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "supplier_id", columnDefinition = "INT DEFAULT 0")
    private int supplierId;

    @Column(name = "name", columnDefinition = "VARCHAR DEFAULT ''")
    private String name;

    @Column(name = "code", columnDefinition = "VARCHAR DEFAULT ''")
    private String code;

    @Column(name = "description", columnDefinition = "VARCHAR DEFAULT ''")
    private String description;

    @Column(name = "amount")
    private double amount;

    @Column(name = "discount_percent", columnDefinition = "INT DEFAULT 0")
    private int discountPercent;

    @Column(name = "status", columnDefinition = "INT DEFAULT 0")
    private int status;

	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductDetail> ProductDetail;

    
}

=======
@Table(name = "Products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String description;
	Double amount;
	String code;
	int status;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createAt")
	Date createAt = new Date();
	Boolean available;

	@ManyToOne
	@JoinColumn(name = "Categoryid")
	Category category;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
}
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
