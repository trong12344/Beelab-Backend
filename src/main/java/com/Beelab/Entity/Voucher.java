package com.Beelab.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voucher")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int discount_amount;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private int type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expired_at", nullable = false)
    private Date expired_at;
    
    @JsonIgnore
	@OneToMany(mappedBy = "voucher")
	List<OrderDetail> OrderDetail;

}