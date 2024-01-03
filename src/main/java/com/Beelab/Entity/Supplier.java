package com.Beelab.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String name;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String description;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String phone_number;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String address;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "supplierId")
    List<Product> product;


}
