package com.yauhescha.javashiki.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class FavoriteApiTest extends CommonTestData {

    @Test
    public void createDestroyFavorite() {
        favoriteApi.createFavorite("Anime", 20);
        favoriteApi.destroyFavorite("Anime", 20);
        assertTrue(true);
    }

    @Test
    public void createFavoriteWithKind() {
        favoriteApi.createFavorite("Person", 1, "seyu");
        favoriteApi.destroyFavorite("Person", 1);
        assertTrue(true);
    }

    @Test
    public void reorderFavorite() {
        favoriteApi.reorderFavorite(1, 0);
        assertTrue(true);
    }
}
