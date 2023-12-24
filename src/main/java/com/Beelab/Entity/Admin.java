package com.Beelab.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String lastName;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String fullName;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Long salaryId;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE DEFAULT NULL")
    private Date birthday;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String password;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updatedAt;

    @JsonIgnore
	@OneToMany(mappedBy = "staff")
	List<OrderDetail> OrderDetail;

}

