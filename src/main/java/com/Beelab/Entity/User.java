package com.Beelab.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String full_name;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE DEFAULT NULL")
    private String address;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String password_hash;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private int phone_number;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String token;


	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    List<Cart> cart;


    @ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "normalized_name")
    )
    @JsonIgnore
    private java.util.List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
