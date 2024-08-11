package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Publisher;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PublisherApiTest extends CommonTestData {

    @Test
    public void getList() {
        List<Publisher> list = publisherApi.getList();
        assertFalse(list.isEmpty());

        // Проверка первого издателя
        Publisher publisher1 = list.get(0);
        assertEquals(1510, publisher1.getId().intValue());
        assertEquals("Web Action", publisher1.getName());

        // Проверка второго издателя
        Publisher publisher2 = list.get(1);
        assertEquals(1491, publisher2.getId().intValue());
        assertEquals("equal", publisher2.getName());

        // Проверка третьего издателя
        Publisher publisher3 = list.get(2);
        assertEquals(1511, publisher3.getId().intValue());
        assertEquals("Natsuyoshi", publisher3.getName());

        // Проверка четвертого издателя
        Publisher publisher4 = list.get(3);
        assertEquals(1494, publisher4.getId().intValue());
        assertEquals("Manga DX", publisher4.getName());
    }

}