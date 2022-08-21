package com.yauhescha.javashiki.util.search;

public enum SearchOrderStatus {
    ANONS("anons"),
    ONGOING("ongoing"),
    RELEASED("released");

    private final String name;

    SearchOrderStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
