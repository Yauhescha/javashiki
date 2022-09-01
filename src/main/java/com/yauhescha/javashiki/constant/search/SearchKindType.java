package com.yauhescha.javashiki.constant.search;

public enum SearchKindType {

    SEYU("seyu"),
    MANGAKA("mangaka"),
    PRODUCER("producer");

    private final String name;

    SearchKindType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
