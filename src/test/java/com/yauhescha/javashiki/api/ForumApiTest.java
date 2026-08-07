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

        Forum forum1 = forums.get(0);
        assertEquals(1, forum1.getId().intValue());
        assertEquals("Аниме и манга", forum1.getName());
        assertEquals("animanga", forum1.getPermalink());
        assertEquals("/forum/animanga", forum1.getUrl());

        assertTrue("Expected at least 10 forums", forums.size() >= 10);
    }

}
