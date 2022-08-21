package com.yauhescha.javashiki.util.search;

public enum SearchOrderDuration {
    LESS_THAN_10_MINUTES("S"),
    LESS_THAN_30_MINUTES("D"),
    MORE_THAN_30_MINUTES("F");

    private final String name;

    SearchOrderDuration(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
