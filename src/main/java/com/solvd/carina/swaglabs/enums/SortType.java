package com.solvd.carina.swaglabs.enums;

public enum SortType {

    PRICE_LOW_TO_HIGH("Price (low to high)"),
    PRICE_HIGH_TO_LOW("Price (high to low)"),
    NAME_A_TO_Z("Name (A to Z)"),
    NAME_Z_TO_A("Name (Z to A)");

    SortType(String value) {
        this.value = value;
    }

    final String value;

    public String getValue() {
        return value;
    }
}
