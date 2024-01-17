package com.Beelab.Entity;


import com.Beelab.Common.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "product_image")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "url")

public class ProductImage  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(updatable = false, nullable = false,name = "url",length = 500)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    private Color forColor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
