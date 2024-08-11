package com.yauhescha.javashiki.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StatsApiTest extends CommonTestData {

    @Test
    public void getList() {
        List<Long> list = statsApi.getList();
        assertTrue(list.size() > 100);
        for (int i = 0; i < 100; i++) {
            assertTrue(list.get(i) > 1);
        }
    }
}