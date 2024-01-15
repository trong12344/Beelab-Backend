package com.Beelab.Entity;


import com.Beelab.Common.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import com.Beelab.Entity.ProductDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@SuppressWarnings("serial")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR DEFAULT ''")
    private String name;

    @Column(name = "code", columnDefinition = "VARCHAR DEFAULT ''")
    private String code;

    @Column(name = "description", columnDefinition = "VARCHAR DEFAULT ''")
    private String description;

    @Column(name = "amount")
    private double amount;

    @Column(name = "display_image")
    private String displayImage;

    @Column(name = "discount_percent", columnDefinition = "INT DEFAULT 0")
    private int discountPercent;

    @Column(name = "status", columnDefinition = "INT DEFAULT 0")
    private int status;

	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductDetail> ProductDetail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductImage> image;

    public double getFinalPrice(){
        return amount - amount*discountPercent/100;
    }
}

