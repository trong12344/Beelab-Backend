package com.Beelab.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.Beelab.Common.AuditableEntity;
import com.Beelab.Enum.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "userPhoneNumber", nullable = false)
    private String userPhoneNumber;

    @Column(name = "userEmail", nullable = false)
    private String userEmail;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String address;

    @Column(name = "status", columnDefinition = "INT DEFAULT 1")
    @Builder.Default
    private OrderStatus status = OrderStatus.UNPROCESSED;

    @Column(name = "total_amout", columnDefinition = "DOUBLE DEFAULT 0.0")
    private double totalAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated_at;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	List<OrderDetail> orderDetails;


}