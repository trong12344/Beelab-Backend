package com.Beelab.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity", columnDefinition = "INT DEFAULT 0")
    private int quantity;

    @Column(name = "status", columnDefinition = "INT DEFAULT 0")
    private int status;

    @Column(name = "image_url", columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String image_url;

    @Column(name = "sold_quantity", columnDefinition = "INT DEFAULT 0")
    private int sold_quantity;
    
    @JsonIgnore
	@OneToMany(mappedBy = "productDetail")
	List<OrderDetail> orderDetails;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;   
    
    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;
    
    
    @JsonIgnore
  	@OneToMany(mappedBy = "ProductDetail")
  	List<Cart> Cart;
    
    
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
    
}

