package com.yauhescha.javashiki.constant;

public enum TopicKind {
    ANONS("anons"),
    ONGOING("ongoing"),
    RELEASED("released"),
    EPISODE("episode");

    private final String name;

    TopicKind(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
