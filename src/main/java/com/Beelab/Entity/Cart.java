package com.Beelab.Entity;

import com.Beelab.Common.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(updatable = false, nullable = false,name = "user_id")
    private int user_id;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int quantity;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int status;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;

    
    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    ProductDetail ProductDetail;

}

