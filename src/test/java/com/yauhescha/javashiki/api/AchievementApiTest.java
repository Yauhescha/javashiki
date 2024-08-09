package com.yauhescha.javashiki.api;


import com.yauhescha.javashiki.model.domen.Achievement;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AchievementApiTest extends CommonTestData {

    @Test
    public void testGetAchievements() {
        List<Achievement> achievements = achievementApi.getAchievements(TEST_USER_ID);
        Assert.assertNotNull(achievements);
        Achievement achievement = achievements.stream()
            .filter(item -> item.getId() == 2276707586L)
            .findFirst()
            .get();
        Assert.assertEquals("tetsurou_araki", achievement.getNekoId());
        Assert.assertEquals(1L, achievement.getLevel().longValue());
        Assert.assertEquals(100L, achievement.getProgress().longValue());
    }
}