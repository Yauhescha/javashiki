package com.yauhescha.javashiki.constant.search;

public enum SearchMangaKind {
    MANGA("manga"),
    MANHWA("manhwa"),
    MANHUA("manhua"),
    LIGHT_NOVEL("light_novel"),
    NOVEL("novel"),
    ONE_SHOT("one_shot"),
    DOUJIN("doujin");

    private final String name;

    SearchMangaKind(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
