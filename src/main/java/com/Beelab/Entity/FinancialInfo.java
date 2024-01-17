package com.Beelab.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinancialInfo {
    private BigDecimal doanhThu;
    private BigDecimal chiPhi;
    private BigDecimal loiNhuan;
}