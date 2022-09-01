package com.yauhescha.javashiki.constant.search;

public enum SearchMangaOrder {
    ID("id"),
    RANKED("ranked"),
    KIND("kind"),
    POPULARITY("popularity"),
    NAME("name"),
    AIRED_ON("aired_on"),
    VOLUMES("volumes"),
    CHAPTERS("chapters"),
    STATUS("status"),
    RANDOM("random");

    private final String name;

    SearchMangaOrder(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
