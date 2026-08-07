package com.yauhescha.javashiki.api;


import com.yauhescha.javashiki.model.domen.Achievement;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AchievementApiTest extends CommonTestData {

    @Test
    public void testGetAchievements() {
        List<Achievement> achievements = achievementApi.getAchievements(TEST_USER_ID);
        assertNotNull(achievements);
    }
}