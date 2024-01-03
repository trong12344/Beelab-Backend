package com.Beelab.Entity;

import com.Beelab.Common.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import com.Beelab.Entity.ProductDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "color")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Color extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "id")
    private int id;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String name;

    @Column(columnDefinition = "VARCHAR DEFAULT ''")
    private String description;

    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private List<ProductDetail> ProductDetail;

//    @OneToMany(mappedBy = "forColor", fetch = FetchType.LAZY)
//    private List<ProductImage> productImages;
}
