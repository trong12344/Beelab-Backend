package com.Beelab.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	@OneToMany(mappedBy = "user")
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

    public List<String> getPermissions() {
        List<String> permissions = new ArrayList<>();
        List<Permission> collection = new ArrayList<>();
        for (Role role : this.getRoles()) {
            permissions.add(role.getNormalizedName());
            collection.addAll(role.getPermissions());
        }
        for (Permission item : collection) {
            permissions.add(item.getNormalizedName());
        } if(this.getRoles().equals("ROLE_EMPLOYEE")){
            permissions.add("ADMIN_DASHBOARD");
        }
        return permissions;
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getGrantedAuthorities(getPermissions());
    }

    @Override
    public String getPassword() {
        return password_hash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
