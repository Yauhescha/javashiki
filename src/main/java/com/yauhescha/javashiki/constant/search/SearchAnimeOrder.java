package com.yauhescha.javashiki.constant.search;

public enum SearchAnimeOrder {
    ID("id"),
    RANKED("ranked"),
    KIND("kind"),
    POPULARITY("popularity"),
    NAME("name"),
    AIRED_ON("aired_on"),
    EPISODES("episodes"),
    STATUS("status"),
    RANDOM("random");

    private final String name;

    SearchAnimeOrder(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
