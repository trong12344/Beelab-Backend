package com.Beelab.Entity;

import java.math.BigDecimal;

public class LoiNhuan {
    private BigDecimal loiNhuan;

    // Constructor
    public LoiNhuan(BigDecimal loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    // Getters and Setters (nếu cần)
    public BigDecimal getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(BigDecimal loiNhuan) {
        this.loiNhuan = loiNhuan;
    }
}

