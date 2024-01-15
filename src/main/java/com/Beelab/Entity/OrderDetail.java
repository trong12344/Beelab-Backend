package com.Beelab.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.Beelab.Common.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_detail_bill")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "order_id", nullable = false)
    private int order_id;

    @Column(name = "product_detail_id", nullable = false)
    private int productDetailId;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_detail_id", insertable = false, updatable = false)
    private ProductDetail productDetail;


}
