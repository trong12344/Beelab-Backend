package com.Beelab.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int quantity;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int status;

    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Date createdAt;

    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp on update current_timestamp")
    private Date updatedAt;
    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    
    
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    ProductDetail ProductDetail;

}

