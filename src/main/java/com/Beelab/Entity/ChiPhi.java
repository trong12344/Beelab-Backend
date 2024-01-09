package com.Beelab.Entity;

import java.math.BigDecimal;

public class ChiPhi {
    private BigDecimal totalAmount;

    public ChiPhi() {
        // Constructor mặc định
    }

    public ChiPhi(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
