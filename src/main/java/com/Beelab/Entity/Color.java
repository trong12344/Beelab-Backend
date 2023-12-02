package com.Beelab.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import com.Beelab.Entity.ProductDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String name;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String description;

    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private List<ProductDetail> ProductDetail;

    
}
