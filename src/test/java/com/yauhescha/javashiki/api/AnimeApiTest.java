package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.constant.search.SearchAnimeKind;
import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.Genre;
import com.yauhescha.javashiki.model.domen.RatesScoresStat;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.model.domen.Studio;
import com.yauhescha.javashiki.model.domen.Video;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class AnimeApiTest extends CommonTestData {

    @Test
    public void getAnimesTv() {
        AnimeSearchParameters parameters = AnimeSearchParameters.builder()
            .search("naruto")
            .kind(SearchAnimeKind.TV)
            .build();
        List<Anime> animes = animeApi.getAnimes(parameters);
        assertFalse(animes.isEmpty());
        Anime anime = animes.get(0);
        assertEquals("Naruto", anime.getName());
        assertEquals("Наруто", anime.getRussian());
        assertEquals("released", anime.getStatus());
        assertEquals(220, anime.getEpisodes().longValue());
        assertEquals("tv", anime.getKind());
    }
    @Test
    public void getAnimesMovie() {
        AnimeSearchParameters parameters = AnimeSearchParameters.builder()
            .search("naruto")
            .kind(SearchAnimeKind.MOVIE)
            .build();
        List<Anime> animes = animeApi.getAnimes(parameters);
        assertFalse(animes.isEmpty());
        Anime anime = animes.get(0);
        assertEquals("Naruto: Shippuuden Movie 3 - Hi no Ishi wo Tsugu Mono", anime.getName());
        assertEquals("Наруто: Ураганные хроники 3 — Наследники воли огня", anime.getRussian());
        assertEquals("released", anime.getStatus());
        assertEquals(1, anime.getEpisodes().longValue());
        assertEquals("movie", anime.getKind());
    }

    @Test
    public void getAnimeDetail() {
        Optional<AnimeFull> animeDetail = animeApi.getAnimeDetail(20, false);
        assertTrue(animeDetail.isPresent());
        AnimeFull anime = animeDetail.get();

        // Проверка основных полей
        assertEquals("Naruto", anime.getName());
        assertEquals("Наруто", anime.getRussian());
        assertEquals("released", anime.getStatus());
        assertEquals(220, anime.getEpisodes().longValue());
        assertEquals("tv", anime.getKind());

        // Проверка дополнительных полей
        assertEquals("pg_13", anime.getRating());
        assertEquals(List.of("Naruto"), anime.getEnglish());
        assertEquals(List.of("ナルト"), anime.getJapanese());
        assertEquals(List.of("NARUTO"), anime.getSynonyms());
        assertEquals("Наруто", anime.getLicenseNameRu());
        assertEquals(23, anime.getDuration().intValue());

        // Проверка описания
        String expectedDescription = "В день рождения Наруто Узумаки на деревню под названием Коноха напал легендарный демон, [character=7407]Девятихвостый лис[/character]. Четвёртый Хокагэ [波風ミナト] ценой своей жизни спас деревню, запечатав демона в новорождённом Наруто, неосознанно обрекая его на жизнь в ненависти односельчан.";
        assertTrue(anime.getDescription().contains(expectedDescription));


        assertEquals("naruto", anime.getFranchise());
        assertFalse(anime.getFavoured());
        assertFalse(anime.getAnons());
        assertFalse(anime.getOngoing());
        assertEquals(4346, anime.getThreadId().intValue());
        assertEquals(4346, anime.getTopicId().intValue());
        assertEquals(20, anime.getMyanimelistId().intValue());

        // Проверка фан-субберов
        List<String> expectedFansubbers = Arrays.asList("Alex & Julia", "RG Genshiken", "2nd Life Fansubs", "BTTF", "Kolonel & ALF!", "Anime Kazan Club");
        assertEquals(expectedFansubbers, anime.getFansubbers());

        // Проверка фан-даберов
        List<String> expectedFandubbers = Arrays.asList("SHIZA Project", "AnimeGroup", "Jetix", "2x2", "QTV", "Suzaku", "OpenDub");
        assertEquals(expectedFandubbers, anime.getFandubbers());

        // Проверка лицензий
        List<String> expectedLicensors = List.of("2x2");
        assertEquals(expectedLicensors, anime.getLicensors());

        // Проверка жанров
        List<Genre> expectedGenres = Arrays.asList(
            new Genre(1L, "Action", "Экшен", "genre"),
            new Genre(2L, "Adventure", "Приключения", "genre"),
            new Genre(10L, "Fantasy", "Фэнтези", "genre"),
            new Genre(17L, "Martial Arts", "Боевые искусства", "genre"),
            new Genre(27L, "Shounen", "Сёнен", "genre")
        );
        assertEquals(expectedGenres, anime.getGenres());

        // Проверка студий
        List<Studio> expectedStudios = List.of(new Studio(1L, "Pierrot", "Pierrot", true, "/system/studios/original/1.png?1378753179"));
        assertEquals(expectedStudios, anime.getStudios());

        // Проверка видео
        List<Video> expectedVideos = Arrays.asList(
            new Video(54565L, "https://youtu.be/OJGBr5pL93U", "http://img.youtube.com/vi/OJGBr5pL93U/hqdefault.jpg", "http://youtube.com/embed/OJGBr5pL93U", "Трейлер Jetix", "pv", "youtube"),
            new Video(56624L, "https://youtu.be/savpNb36YzA", "http://img.youtube.com/vi/savpNb36YzA/hqdefault.jpg", "http://youtube.com/embed/savpNb36YzA", "Трейлер 2x2", "pv", "youtube")
        );
        assertEquals(expectedVideos, anime.getVideos());

        // Проверка скриншотов
        List<Screenshot> expectedScreenshots = Arrays.asList(
            new Screenshot("/system/screenshots/original/bdf5492d8e02b06a85b5c53a1b37b75fbdc1d960.jpg?1701215427", "/system/screenshots/x332/bdf5492d8e02b06a85b5c53a1b37b75fbdc1d960.jpg?1701215427"),
            new Screenshot("/system/screenshots/original/98f3fa89e9a47b9671d94bcdfbe76725f7335551.jpg?1701215428", "/system/screenshots/x332/98f3fa89e9a47b9671d94bcdfbe76725f7335551.jpg?1701215428")
        );
        assertEquals(expectedScreenshots, anime.getScreenshots());
    }


    @Test
    public void getScreenshots() {
    }

    @Test
    public void getRoles() {
    }

    @Test
    public void getSimilar() {
    }

    @Test
    public void getRelated() {
    }

    @Test
    public void getExternalLinks() {
    }

    @Test
    public void getFranchise() {
    }

    @Test
    public void getTopics() {
    }

    @Test
    public void testGetTopics() {
    }
}