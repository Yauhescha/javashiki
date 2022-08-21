package com.yauhescha.javashiki.constant.search;

public enum SearchOrderKind {
    TV("tv"),
    MOVIE("movie"),
    OVA("ova"),
    ONA("ona"),
    SPECIAL("special"),
    MUSIC("music"),
    TV13("tv_13"),
    TV24("tv_24"),
    TV48("tv_48");

    private final String name;

    SearchOrderKind(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
