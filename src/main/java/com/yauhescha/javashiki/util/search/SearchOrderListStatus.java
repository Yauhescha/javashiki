package com.yauhescha.javashiki.util.search;

public enum SearchOrderListStatus {
    PLANNED("planned"),
    WATCHING("watching"),
    REWATCHING("rewatching"),
    COMPLETED("completed"),
    ON_HOLD("on_hold"),
    DROPPED("dropped");

    private final String name;

    SearchOrderListStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
