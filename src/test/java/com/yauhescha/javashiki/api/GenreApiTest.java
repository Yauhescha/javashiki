package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Genre;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenreApiTest extends CommonTestData {

    @Test
    public void getList() {
        List<Genre> list = genreApi.getList();
        assertFalse(list.isEmpty());

        // Проверка первого жанра
        Genre genre1 = list.get(0);
        assertEquals(89, genre1.getId().intValue());
        assertEquals("Police", genre1.getName());
        assertEquals("Полиция", genre1.getRussian());
        assertEquals("genre", genre1.getKind());

        // Проверка второго жанра
        Genre genre2 = list.get(1);
        assertEquals(8, genre2.getId().intValue());
        assertEquals("Drama", genre2.getName());
        assertEquals("Драма", genre2.getRussian());
        assertEquals("genre", genre2.getKind());

        // Проверка третьего жанра
        Genre genre3 = list.get(2);
        assertEquals(11, genre3.getId().intValue());
        assertEquals("Game", genre3.getName());
        assertEquals("Игры", genre3.getRussian());
        assertEquals("genre", genre3.getKind());
    }

}