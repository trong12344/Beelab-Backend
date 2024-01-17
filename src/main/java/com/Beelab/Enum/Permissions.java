package com.Beelab.Enum;

public enum Permissions {
    PRODUCT_MANAGEMENT("PRODUCT_MANAGEMENT"),
    USER_MANAGEMENT("USER_MANAGEMENT"),
    ORDER_MANAGEMENT("ORDER_MANAGEMENT"),
    CATEGORY_MANAGEMENT("CATEGORY_MANAGEMENT"),
    PROMOTION_MANAGEMENT("PROMOTION_MANAGEMENT"),
    SUPPLIER_MANAGEMENT("SUPPLIER_MANAGEMENT"),
    REPORT_MANAGEMENT("REPORT_MANAGEMENT"),
    ROLE_MANAGEMENT("ROLE_MANAGEMENT"),
    CAN_ORDER("CAN_ORDER"),
    ADMIN_DASHBOARD("ADMIN_DASHBOARD"),
    ;

    private final String text;

    Permissions(final String permissions) {
        this.text = permissions;
    }

    @Override
    public String toString() {
        return text;
    }
}
