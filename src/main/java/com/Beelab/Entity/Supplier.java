package com.Beelab.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
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


    // Getters and setters, other methods...
}
