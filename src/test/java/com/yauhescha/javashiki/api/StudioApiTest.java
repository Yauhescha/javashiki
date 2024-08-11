package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Studio;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudioApiTest extends CommonTestData {

    @Test
    public void getList() {
        List<Studio> list = studioApi.getList();
        assertFalse(list.isEmpty());

        // Проверка первого студии
        Studio studio1 = list.get(0);
        assertEquals(2022, studio1.getId().intValue());
        assertEquals("TYMOTE", studio1.getName());
        assertEquals("TYMOTE", studio1.getFilteredName());
        assertFalse(studio1.getReal());
        assertNull(studio1.getImage());

        // Проверка второго студии
        Studio studio2 = list.get(1);
        assertEquals(2023, studio2.getId().intValue());
        assertEquals("Spoon", studio2.getName());
        assertEquals("Spoon", studio2.getFilteredName());
        assertFalse(studio2.getReal());
        assertNull(studio2.getImage());

        // Проверка третьего студии
        Studio studio3 = list.get(2);
        assertEquals(1356, studio3.getId().intValue());
        assertEquals("Tonko House", studio3.getName());
        assertEquals("Tonko House", studio3.getFilteredName());
        assertFalse(studio3.getReal());
        assertNull(studio3.getImage());

        // Проверка четвертого студии
        Studio studio4 = list.get(3);
        assertEquals(1992, studio4.getId().intValue());
        assertEquals("Bandai Spirits", studio4.getName());
        assertEquals("Bandai Spirits", studio4.getFilteredName());
        assertFalse(studio4.getReal());
        assertNull(studio4.getImage());

        // Проверка пятого студии
        Studio studio5 = list.get(4);
        assertEquals(2007, studio5.getId().intValue());
        assertEquals("Studio Drive", studio5.getName());
        assertEquals("Drive", studio5.getFilteredName());
        assertFalse(studio5.getReal());
        assertNull(studio5.getImage());
    }

}