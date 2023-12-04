package com.Beelab.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String full_name;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE DEFAULT NULL")
    private Date birthday;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String phone_number;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String verify_code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "verify_code_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date verify_code_at;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;

//	@JsonIgnore
//	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
//	List<Authority> authorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Cart> cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Comment> comment;
	
	
}
