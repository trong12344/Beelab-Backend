package com.Beelab.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;
import com.Beelab.Entity.ProductDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
@SuppressWarnings("serial")
@Data
@Entity
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

    @Column(name = "amount", columnDefinition = "INT DEFAULT 0")
    private int amount;

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

