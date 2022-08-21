package com.yauhescha.javashiki.util.search;

public enum SearchOrderRating {
    NO_RATING("none"),
    ALL_AGES("g"),
    CHILDREN("pg"),
    TEENS_13_OR_OLDER("pg_13"),
    RECOMMENDED_17_PLUS("r"),
    MILD_NUDITY("r_plus"),
    HENTAI("rx");

    private final String name;

    SearchOrderRating(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
