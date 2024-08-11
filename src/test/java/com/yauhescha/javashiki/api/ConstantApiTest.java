package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.consant.AnimeMangaConstant;
import com.yauhescha.javashiki.model.domen.consant.ClubConstant;
import com.yauhescha.javashiki.model.domen.consant.SmileConstant;
import com.yauhescha.javashiki.model.domen.consant.UserRateConstant;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ConstantApiTest extends CommonTestData{

    @Test
    public void getAnimeConstant() {
        AnimeMangaConstant animeConstant = constantApi.getAnimeConstant();
        assertNotNull(animeConstant);

        // Проверка списка "kind"
        List<String> expectedKinds = Arrays.asList("tv", "movie", "ova", "ona", "special", "tv_special", "music", "pv", "cm");
        assertNotNull(animeConstant.getKind());
        assertEquals(expectedKinds.size(), animeConstant.getKind().size());
        assertTrue(animeConstant.getKind().containsAll(expectedKinds));

        // Проверка списка "status"
        List<String> expectedStatuses = Arrays.asList("anons", "ongoing", "released");
        assertNotNull(animeConstant.getStatus());
        assertEquals(expectedStatuses.size(), animeConstant.getStatus().size());
        assertTrue(animeConstant.getStatus().containsAll(expectedStatuses));
    }


    @Test
    public void getMangaConstant() {
        AnimeMangaConstant mangaConstant = constantApi.getMangaConstant();
        assertNotNull(mangaConstant);

        // Проверка списка "kind"
        List<String> expectedKinds = Arrays.asList("manga", "manhwa", "manhua", "light_novel", "novel", "one_shot", "doujin");
        assertNotNull(mangaConstant.getKind());
        assertEquals(expectedKinds.size(), mangaConstant.getKind().size());
        assertTrue(mangaConstant.getKind().containsAll(expectedKinds));

        // Проверка списка "status"
        List<String> expectedStatuses = Arrays.asList("anons", "ongoing", "released", "paused", "discontinued");
        assertNotNull(mangaConstant.getStatus());
        assertEquals(expectedStatuses.size(), mangaConstant.getStatus().size());
        assertTrue(mangaConstant.getStatus().containsAll(expectedStatuses));
    }


    @Test
    public void getUserRateConstant() {
        UserRateConstant userRateConstant = constantApi.getUserRateConstant();
        assertNotNull(userRateConstant);

        // Проверка списка "status"
        List<String> expectedStatuses = Arrays.asList("planned", "watching", "rewatching", "completed", "on_hold", "dropped");
        assertNotNull(userRateConstant.getStatus());
        assertEquals(expectedStatuses.size(), userRateConstant.getStatus().size());
        assertTrue(userRateConstant.getStatus().containsAll(expectedStatuses));
    }

    @Test
    public void getClubConstant() {
        ClubConstant clubConstant = constantApi.getClubConstant();
        assertNotNull(clubConstant);

        // Проверка списка "joinPolicy"
        List<String> expectedJoinPolicies = Arrays.asList("free", "member_invite", "admin_invite", "owner_invite");
        assertNotNull(clubConstant.getJoinPolicy());
        assertEquals(expectedJoinPolicies.size(), clubConstant.getJoinPolicy().size());
        assertTrue(clubConstant.getJoinPolicy().containsAll(expectedJoinPolicies));

        // Проверка списка "commentPolicy"
        List<String> expectedCommentPolicies = Arrays.asList("free", "members", "admins");
        assertNotNull(clubConstant.getCommentPolicy());
        assertEquals(expectedCommentPolicies.size(), clubConstant.getCommentPolicy().size());
        assertTrue(clubConstant.getCommentPolicy().containsAll(expectedCommentPolicies));

        // Проверка списка "imageUploadPolicy"
        List<String> expectedImageUploadPolicies = Arrays.asList("members", "admins");
        assertNotNull(clubConstant.getImageUploadPolicy());
        assertEquals(expectedImageUploadPolicies.size(), clubConstant.getImageUploadPolicy().size());
        assertTrue(clubConstant.getImageUploadPolicy().containsAll(expectedImageUploadPolicies));
    }


    @Test
    public void getSmileConstant() {
        List<SmileConstant> smileConstants = constantApi.getSmileConstant();
        assertNotNull(smileConstants);
        assertFalse(smileConstants.isEmpty());

        // Проверка первого смайлика
        SmileConstant smile1 = smileConstants.get(0);
        assertEquals(":)", smile1.getBbcode());
        assertEquals("/images/smileys/:).gif", smile1.getPath());

        // Проверка второго смайлика
        SmileConstant smile2 = smileConstants.get(1);
        assertEquals(":D", smile2.getBbcode());
        assertEquals("/images/smileys/:D.gif", smile2.getPath());

        // Проверка третьего смайлика
        SmileConstant smile3 = smileConstants.get(2);
        assertEquals(":-D", smile3.getBbcode());
        assertEquals("/images/smileys/:-D.gif", smile3.getPath());

        // Проверка четвертого смайлика
        SmileConstant smile4 = smileConstants.get(3);
        assertEquals(":lol:", smile4.getBbcode());
        assertEquals("/images/smileys/:lol:.gif", smile4.getPath());
    }

}