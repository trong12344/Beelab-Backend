package com.Beelab.Entity;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String name;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String description;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int status;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated_at;
    
    @OneToMany(mappedBy = "size")
    @JsonIgnore
    private List<ProductDetail> ProductDetail;

    

}
