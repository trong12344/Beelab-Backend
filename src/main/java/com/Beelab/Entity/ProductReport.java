package com.Beelab.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReport {
 @Id
 @Column(name = "product_id")
 private Long productId;
 @Column(name = "product_name")
 private String productName;
 @Column(name = "category_name")
 private String categoryName;
 @Column(name = "product_amount")
 private double productAmount;
 @Column(name = "product_quantity")
 private int productQuantity;
 @Column(name = "product_sold")
 private int productSold;
 @Column(name = "product_expense")
 private double productExpense;
 @Column(name = "product_totalmount")
 private double productTotalAmount;
/* @Transient
 private BigDecimal total_product_expense;
 @Transient
 private BigDecimal total_product_almount;*/
}