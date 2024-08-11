package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Forum;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ForumApiTest extends CommonTestData{

    @Test
    public void getForums() {
        List<Forum> forums = forumApi.getForums();
        assertFalse(forums.isEmpty());

        // Проверка первого форума
        Forum forum1 = forums.get(0);
        assertEquals(1, forum1.getId().intValue());
        assertEquals(1, forum1.getPosition().intValue());
        assertEquals("Аниме и манга", forum1.getName());
        assertEquals("animanga", forum1.getPermalink());
        assertEquals("/forum/animanga", forum1.getUrl());

        // Проверка второго форума
        Forum forum2 = forums.get(1);
        assertEquals(20, forum2.getId().intValue());
        assertEquals(5, forum2.getPosition().intValue());
        assertEquals("Новости", forum2.getName());
        assertEquals("news", forum2.getPermalink());
        assertEquals("/forum/news", forum2.getUrl());

        // Проверка третьего форума
        Forum forum3 = forums.get(2);
        assertEquals(4, forum3.getId().intValue());
        assertEquals(7, forum3.getPosition().intValue());
        assertEquals("Сайт", forum3.getName());
        assertEquals("site", forum3.getPermalink());
        assertEquals("/forum/site", forum3.getUrl());

        // Проверка четвертого форума
        Forum forum4 = forums.get(3);
        assertEquals(8, forum4.getId().intValue());
        assertEquals(8, forum4.getPosition().intValue());
        assertEquals("Оффтопик", forum4.getName());
        assertEquals("offtopic", forum4.getPermalink());
        assertEquals("/forum/offtopic", forum4.getUrl());
    }

}