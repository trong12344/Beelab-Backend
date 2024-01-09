package com.Beelab.Entity;

import java.math.BigDecimal;

public class DoanhThu {
    private BigDecimal totalAmount;

    public DoanhThu() {
        // Constructor mặc định
    }

    public DoanhThu(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
