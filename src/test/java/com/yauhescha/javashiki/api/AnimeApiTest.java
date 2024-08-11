package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.constant.search.SearchAnimeKind;
import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Forum;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Genre;
import com.yauhescha.javashiki.model.domen.Link;
import com.yauhescha.javashiki.model.domen.Node;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.model.domen.Studio;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.Video;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
        List<Screenshot> screenshots = animeApi.getScreenshots(20);
        assertEquals(43, screenshots.size());

        // Проверка первого скриншота
        Screenshot screenshot1 = screenshots.get(0);
        assertEquals("/system/screenshots/original/bdf5492d8e02b06a85b5c53a1b37b75fbdc1d960.jpg?1701215427", screenshot1.getOriginal());
        assertEquals("/system/screenshots/x332/bdf5492d8e02b06a85b5c53a1b37b75fbdc1d960.jpg?1701215427", screenshot1.getPreview());

        // Проверка второго скриншота
        Screenshot screenshot2 = screenshots.get(1);
        assertEquals("/system/screenshots/original/98f3fa89e9a47b9671d94bcdfbe76725f7335551.jpg?1701215428", screenshot2.getOriginal());
        assertEquals("/system/screenshots/x332/98f3fa89e9a47b9671d94bcdfbe76725f7335551.jpg?1701215428", screenshot2.getPreview());

        // Проверка третьего скриншота
        Screenshot screenshot3 = screenshots.get(2);
        assertEquals("/system/screenshots/original/0994cde9279e8002a446d65b2eda6d813b1a5946.jpg?1701215429", screenshot3.getOriginal());
        assertEquals("/system/screenshots/x332/0994cde9279e8002a446d65b2eda6d813b1a5946.jpg?1701215429", screenshot3.getPreview());
    }

    @Test
    public void getRoles() {
        List<Roles> roles = animeApi.getRoles(20, true);
        assertEquals(256, roles.size());

        // Проверка первой роли
        Roles role1 = roles.get(0);
        assertEquals(Collections.singletonList("Supporting"), role1.getRoles());
        assertEquals(Collections.singletonList("Supporting"), role1.getRolesRussian());
        assertNotNull(role1.getCharacter());
        assertEquals(809, role1.getCharacter().getId().intValue());
        assertEquals("Anko Mitarashi", role1.getCharacter().getName());
        assertEquals("Анко Митараши", role1.getCharacter().getRussian());
        assertNotNull(role1.getCharacter().getImage());
        assertEquals("/system/characters/original/809.jpg?1716844122", role1.getCharacter().getImage().getOriginal());
        assertEquals("/system/characters/preview/809.jpg?1716844122", role1.getCharacter().getImage().getPreview());
        assertEquals("/system/characters/x96/809.jpg?1716844122", role1.getCharacter().getImage().getX96());
        assertEquals("/system/characters/x48/809.jpg?1716844122", role1.getCharacter().getImage().getX48());
        assertEquals("/characters/809-anko-mitarashi", role1.getCharacter().getUrl());
        assertNull(role1.getPerson());

        // Проверка второй роли
        Roles role2 = roles.get(1);
        assertEquals(Collections.singletonList("Supporting"), role2.getRoles());
        assertEquals(Collections.singletonList("Supporting"), role2.getRolesRussian());
        assertNotNull(role2.getCharacter());
        assertEquals(22648, role2.getCharacter().getId().intValue());
        assertEquals("Homura Mitokado", role2.getCharacter().getName());
        assertEquals("Хомура Митокадо", role2.getCharacter().getRussian());
        assertNotNull(role2.getCharacter().getImage());
        assertEquals("/system/characters/original/22648.jpg?1712025499", role2.getCharacter().getImage().getOriginal());
        assertEquals("/system/characters/preview/22648.jpg?1712025499", role2.getCharacter().getImage().getPreview());
        assertEquals("/system/characters/x96/22648.jpg?1712025499", role2.getCharacter().getImage().getX96());
        assertEquals("/system/characters/x48/22648.jpg?1712025499", role2.getCharacter().getImage().getX48());
        assertEquals("/characters/22648-homura-mitokado", role2.getCharacter().getUrl());
        assertNull(role2.getPerson());

        // Проверка третьей роли
        Roles role3 = roles.get(2);
        assertEquals(Collections.singletonList("Supporting"), role3.getRoles());
        assertEquals(Collections.singletonList("Supporting"), role3.getRolesRussian());
        assertNotNull(role3.getCharacter());
        assertEquals(15759, role3.getCharacter().getId().intValue());
        assertEquals("Mizura", role3.getCharacter().getName());
        assertEquals("Мизура", role3.getCharacter().getRussian());
        assertNotNull(role3.getCharacter().getImage());
        assertEquals("/system/characters/original/15759.jpg?1712022772", role3.getCharacter().getImage().getOriginal());
        assertEquals("/system/characters/preview/15759.jpg?1712022772", role3.getCharacter().getImage().getPreview());
        assertEquals("/system/characters/x96/15759.jpg?1712022772", role3.getCharacter().getImage().getX96());
        assertEquals("/system/characters/x48/15759.jpg?1712022772", role3.getCharacter().getImage().getX48());
        assertEquals("/characters/15759-mizura", role3.getCharacter().getUrl());
        assertNull(role3.getPerson());

        // Проверка четвертой роли
        Roles role4 = roles.get(3);
        assertEquals(Collections.singletonList("Supporting"), role4.getRoles());
        assertEquals(Collections.singletonList("Supporting"), role4.getRolesRussian());
        assertNotNull(role4.getCharacter());
        assertEquals(206139, role4.getCharacter().getId().intValue());
        assertEquals("Momiji", role4.getCharacter().getName());
        assertEquals("Момиджи", role4.getCharacter().getRussian());
        assertNotNull(role4.getCharacter().getImage());
        assertEquals("/system/characters/original/206139.jpg?1712076104", role4.getCharacter().getImage().getOriginal());
        assertEquals("/system/characters/preview/206139.jpg?1712076104", role4.getCharacter().getImage().getPreview());
        assertEquals("/system/characters/x96/206139.jpg?1712076104", role4.getCharacter().getImage().getX96());
        assertEquals("/system/characters/x48/206139.jpg?1712076104", role4.getCharacter().getImage().getX48());
        assertEquals("/characters/206139-momiji", role4.getCharacter().getUrl());
        assertNull(role4.getPerson());
    }


    @Test
    public void getSimilar() {
        List<Anime> similar = animeApi.getSimilar(20);
        assertNotNull(similar);

        // Проверка первого похожего аниме
        Anime anime1 = similar.get(0);
        assertEquals(34572, anime1.getId().intValue());
        assertEquals("Black Clover", anime1.getName());
        assertEquals("Чёрный клевер", anime1.getRussian());
        assertNotNull(anime1.getImage());
        assertEquals("/system/animes/original/34572.jpg?1711944087", anime1.getImage().getOriginal());
        assertEquals("/system/animes/preview/34572.jpg?1711944087", anime1.getImage().getPreview());
        assertEquals("/system/animes/x96/34572.jpg?1711944087", anime1.getImage().getX96());
        assertEquals("/system/animes/x48/34572.jpg?1711944087", anime1.getImage().getX48());
        assertEquals("/animes/z34572-black-clover", anime1.getUrl());
        assertEquals("tv", anime1.getKind());
        assertEquals("released", anime1.getStatus());
        assertEquals(170, anime1.getEpisodes().intValue());
        assertEquals(170, anime1.getEpisodesAired().intValue());
        assertEquals(LocalDate.of(2017, 10, 3).toString(), anime1.getAiredOn());
        assertEquals(LocalDate.of(2021, 3, 30).toString(), anime1.getReleasedOn());

        // Проверка второго похожего аниме
        Anime anime2 = similar.get(1);
        assertEquals(21, anime2.getId().intValue());
        assertEquals("One Piece", anime2.getName());
        assertEquals("Ван-Пис", anime2.getRussian());
        assertNotNull(anime2.getImage());
        assertEquals("/system/animes/original/21.jpg?1718520367", anime2.getImage().getOriginal());
        assertEquals("/system/animes/preview/21.jpg?1718520367", anime2.getImage().getPreview());
        assertEquals("/system/animes/x96/21.jpg?1718520367", anime2.getImage().getX96());
        assertEquals("/system/animes/x48/21.jpg?1718520367", anime2.getImage().getX48());
        assertEquals("/animes/21-one-piece", anime2.getUrl());
        assertEquals("tv", anime2.getKind());
        assertEquals("ongoing", anime2.getStatus());
        assertEquals(0, anime2.getEpisodes().intValue()); // Для ongoing аниме эпизоды могут быть 0
        assertEquals(1115, anime2.getEpisodesAired().intValue());
        assertEquals(LocalDate.of(1999, 10, 20).toString(), anime2.getAiredOn());

        // Проверка третьего похожего аниме
        Anime anime3 = similar.get(2);
        assertEquals(11061, anime3.getId().intValue());
        assertEquals("Hunter x Hunter (2011)", anime3.getName());
        assertEquals("Охотник х Охотник (2011)", anime3.getRussian());
        assertNotNull(anime3.getImage());
        assertEquals("/system/animes/original/11061.jpg?1711954447", anime3.getImage().getOriginal());
        assertEquals("/system/animes/preview/11061.jpg?1711954447", anime3.getImage().getPreview());
        assertEquals("/system/animes/x96/11061.jpg?1711954447", anime3.getImage().getX96());
        assertEquals("/system/animes/x48/11061.jpg?1711954447", anime3.getImage().getX48());
        assertEquals("/animes/z11061-hunter-x-hunter-2011", anime3.getUrl());
        assertEquals("tv", anime3.getKind());
        assertEquals("released", anime3.getStatus());
        assertEquals(148, anime3.getEpisodes().intValue());
        assertEquals(148, anime3.getEpisodesAired().intValue());
        assertEquals(LocalDate.of(2011, 10, 2).toString(), anime3.getAiredOn());
        assertEquals(LocalDate.of(2014, 9, 24).toString(), anime3.getReleasedOn());
    }


    @Test
    public void getRelated() {
        List<Related> related = animeApi.getRelated(20);
        assertNotNull(related);

        // Проверка первой связи (Adaptation)
        Related related1 = related.get(0);
        assertEquals("Adaptation", related1.getRelation());
        assertEquals("Адаптация", related1.getRelationRussian());
        assertNull(related1.getAnimeShort());
        assertNotNull(related1.getManga());
        assertEquals(11, related1.getManga().getId().intValue());
        assertEquals("Naruto", related1.getManga().getName());
        assertEquals("Наруто", related1.getManga().getRussian());
        assertNotNull(related1.getManga().getImage());
        assertEquals("/system/mangas/original/11.jpg?1708800294", related1.getManga().getImage().getOriginal());
        assertEquals("/system/mangas/preview/11.jpg?1708800294", related1.getManga().getImage().getPreview());
        assertEquals("/system/mangas/x96/11.jpg?1708800294", related1.getManga().getImage().getX96());
        assertEquals("/system/mangas/x48/11.jpg?1708800294", related1.getManga().getImage().getX48());
        assertEquals("/mangas/z11-naruto", related1.getManga().getUrl());
        assertEquals("manga", related1.getManga().getKind());
        assertEquals("released", related1.getManga().getStatus());
        assertEquals(72, related1.getManga().getVolumes().intValue());
        assertEquals(700, related1.getManga().getChapters().intValue());
        assertEquals(LocalDate.of(1999, 9, 21).toString(), related1.getManga().getAiredOn());
        assertEquals(LocalDate.of(2014, 11, 10).toString(), related1.getManga().getReleasedOn());

        // Проверка второй связи (Side Story)
        Related related2 = related.get(1);
        assertEquals("Side Story", related2.getRelation());
        assertEquals("Другая история", related2.getRelationRussian());
        assertNotNull(related2.getAnimeShort());
        assertNull(related2.getManga());
        assertEquals(761, related2.getAnimeShort().getId().intValue());
        assertEquals("Naruto: Akaki Yotsuba no Clover wo Sagase", related2.getAnimeShort().getName());
        assertEquals("Наруто: Найти тёмно-красный четырёхлистный клевер!", related2.getAnimeShort().getRussian());
        assertNotNull(related2.getAnimeShort().getImage());
        assertEquals("/system/animes/original/761.jpg?1711965645", related2.getAnimeShort().getImage().getOriginal());
        assertEquals("/system/animes/preview/761.jpg?1711965645", related2.getAnimeShort().getImage().getPreview());
        assertEquals("/system/animes/x96/761.jpg?1711965645", related2.getAnimeShort().getImage().getX96());
        assertEquals("/system/animes/x48/761.jpg?1711965645", related2.getAnimeShort().getImage().getX48());

        // Проверка третьей связи (Side Story)
        Related related3 = related.get(2);
        assertEquals("Side Story", related3.getRelation());
        assertEquals("Другая история", related3.getRelationRussian());
        assertNotNull(related3.getAnimeShort());
        assertNull(related3.getManga());
        assertEquals(594, related3.getAnimeShort().getId().intValue());
        assertEquals("Naruto: Takigakure no Shitou - Ore ga Eiyuu Dattebayo!", related3.getAnimeShort().getName());
        assertEquals("Наруто: Битва на Хидден-Фолс", related3.getAnimeShort().getRussian());
        assertNotNull(related3.getAnimeShort().getImage());
        assertEquals("/system/animes/original/594.jpg?1711965739", related3.getAnimeShort().getImage().getOriginal());
        assertEquals("/system/animes/preview/594.jpg?1711965739", related3.getAnimeShort().getImage().getPreview());
        assertEquals("/system/animes/x96/594.jpg?1711965739", related3.getAnimeShort().getImage().getX96());
        assertEquals("/system/animes/x48/594.jpg?1711965739", related3.getAnimeShort().getImage().getX48());
    }


    @Test
    public void getExternalLinks() {
        List<ExternalLink> externalLinks = animeApi.getExternalLinks(20);
        assertFalse(externalLinks.isEmpty());

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        // Проверка первой внешней ссылки
        ExternalLink link1 = externalLinks.get(0);
        assertEquals(13287171, link1.getId().intValue());
        assertEquals("official_site", link1.getKind());
        assertEquals("https://www.tv-tokyo.co.jp/anime/naruto2002/", link1.getUrl());
        assertEquals("shikimori", link1.getSource());
        assertEquals(20, link1.getEntryId().intValue());
        assertEquals("Anime", link1.getEntryType());
        assertTrue(link1.getCreatedAt().contains(LocalDateTime.parse("2023-06-20T13:11:00.428+03:00", formatter).toString()));
        assertTrue(link1.getUpdatedAt().contains(LocalDateTime.parse("2023-06-20T13:11:00.428+03:00", formatter).toString()));

        // Проверка второй внешней ссылки
        ExternalLink link2 = externalLinks.get(1);
        assertEquals(13287172, link2.getId().intValue());
        assertEquals("wikipedia", link2.getKind());
        assertEquals("https://ru.wikipedia.org/wiki/Наруто", link2.getUrl());
        assertEquals("shikimori", link2.getSource());
        assertEquals(20, link2.getEntryId().intValue());
        assertEquals("Anime", link2.getEntryType());
        assertTrue(link2.getCreatedAt().contains(LocalDateTime.parse("2018-08-18T04:35:05.238+03:00", formatter).toString()));
        assertTrue(link2.getUpdatedAt().contains(LocalDateTime.parse("2020-02-09T11:57:40.522+03:00", formatter).toString()));

        // Проверка третьей внешней ссылки
        ExternalLink link3 = externalLinks.get(2);
        assertEquals(13287173, link3.getId().intValue());
        assertEquals("wikipedia", link3.getKind());
        assertEquals("https://en.wikipedia.org/wiki/Naruto", link3.getUrl());
        assertEquals("shikimori", link3.getSource());
        assertEquals(20, link3.getEntryId().intValue());
        assertEquals("Anime", link3.getEntryType());
        assertTrue(link3.getCreatedAt().contains(LocalDateTime.parse("2020-07-30T14:05:45.611+03:00", formatter).toString()));
        assertTrue(link3.getUpdatedAt().contains(LocalDateTime.parse("2020-07-30T14:05:45.611+03:00", formatter).toString()));
    }


    @Test
    public void getFranchise() {
        Optional<Franchise> franchiseOptional = animeApi.getFranchise(20);
        assertTrue(franchiseOptional.isPresent());
        Franchise franchise = franchiseOptional.get();

        // Проверка наличия связей и узлов
        assertNotNull(franchise.getLinks());
        assertNotNull(franchise.getNodes());

        // Проверка конкретных связей
        List<Link> links = franchise.getLinks();

        Link link1 = links.get(0);
        assertEquals(35436744, link1.getId().intValue());
        assertEquals(20, link1.getSourceId().intValue());
        assertEquals(442, link1.getTargetId().intValue());
        assertEquals(30, link1.getSource().intValue());
        assertEquals(27, link1.getTarget().intValue());
        assertEquals(10, link1.getWeight().intValue());
        assertEquals("side_story", link1.getRelation());

        Link link2 = links.get(1);
        assertEquals(35436743, link2.getId().intValue());
        assertEquals(20, link2.getSourceId().intValue());
        assertEquals(594, link2.getTargetId().intValue());
        assertEquals(30, link2.getSource().intValue());
        assertEquals(28, link2.getTarget().intValue());
        assertEquals(10, link2.getWeight().intValue());
        assertEquals("side_story", link2.getRelation());

        Link link3 = links.get(2);
        assertEquals(35436742, link3.getId().intValue());
        assertEquals(20, link3.getSourceId().intValue());
        assertEquals(761, link3.getTargetId().intValue());
        assertEquals(30, link3.getSource().intValue());
        assertEquals(29, link3.getTarget().intValue());
        assertEquals(10, link3.getWeight().intValue());
        assertEquals("side_story", link3.getRelation());

        // Проверка конкретных узлов
        List<Node> nodes = franchise.getNodes();
        assertFalse(nodes.isEmpty()); // измените число в зависимости от количества ожидаемых узлов

        Node node1 = nodes.get(0);
        assertEquals(54688, node1.getId().intValue());
        assertEquals("Наруто", node1.getName());
        assertEquals("https://desu.shikimori.one/system/animes/x96/54688.jpg?1718167517", node1.getImageUrl());
        assertEquals("/animes/54688-naruto-shinsaku-anime", node1.getUrl());
        assertNull(node1.getYear()); // Измените в зависимости от ожидаемого значения
        assertEquals("TV Сериал", node1.getKind());
        assertEquals(1, node1.getWeight().intValue());

        Node node2 = nodes.get(1);
        assertEquals(54687, node2.getId().intValue());
        assertEquals("Боруто: Новое поколение Наруто. Часть 2", node2.getName());
        assertEquals("https://desu.shikimori.one/system/animes/x96/54687.jpg?1718354814", node2.getImageUrl());
        assertEquals("/animes/54687-boruto-naruto-next-generations-part-2", node2.getUrl());
        assertNull(node2.getYear()); // Измените в зависимости от ожидаемого значения
        assertEquals("TV Сериал", node2.getKind());
        assertEquals(1, node2.getWeight().intValue());

        Node node3 = nodes.get(2);
        assertEquals(53236, node3.getId().intValue());
        assertEquals("Путь Наруто", node3.getName());
        assertEquals("https://desu.shikimori.one/system/animes/x96/53236.jpg?1711935441", node3.getImageUrl());
        assertEquals("/animes/53236-road-of-naruto", node3.getUrl());
        assertEquals(2022, node3.getYear().intValue());
        assertEquals("Проморолик", node3.getKind());
        assertEquals(2, node3.getWeight().intValue());

        // Проверка текущего идентификатора
        assertEquals(20, franchise.getCurrentId().intValue());
    }

    @Test
    public void getTopics() {
        List<Topic> topics = animeApi.getTopics(20);
        assertFalse(topics.isEmpty());

        // Проверка первого топика
        Topic topic1 = topics.get(0);
        assertEquals(359972, topic1.getId().intValue());
        assertEquals("Боец MMA вышел на бой в образе Тоби из «Наруто»", topic1.getTopicTitle());
        assertNotNull(topic1.getBody());
        assertNotNull(topic1.getHtmlBody());
        assertEquals("", topic1.getHtmlFooter());
        assertTrue(topic1.getCreatedAt().contains(LocalDateTime.parse("2021-11-30T13:07:14.837+03:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toString()));
        assertEquals(0, topic1.getCommentsCount().intValue());

        // Проверка форума
        Forum forum1 = topic1.getForum();
        assertEquals(1, forum1.getId().intValue());
        assertEquals(1, forum1.getPosition().intValue());
        assertEquals("Аниме и манга", forum1.getName());
        assertEquals("animanga", forum1.getPermalink());
        assertEquals("/forum/animanga", forum1.getUrl());

        // Проверка пользователя
        User user1 = topic1.getUser();
        assertEquals(729338, user1.getId().intValue());
        assertEquals("Twinqssly", user1.getNickname());
        assertEquals("https://desu.shikimori.one/system/users/x48/729338.png?1599839580", user1.getAvatar());
        assertNotNull(user1.getImage());
        assertNull(user1.getImage().getOriginal());
        assertNull(user1.getImage().getPreview());
        assertNull(user1.getImage().getX96());
        assertEquals("https://desu.shikimori.one/system/users/x48/729338.png?1599839580", user1.getImage().getX48());
        assertEquals("https://shikimori.one/Twinqssly", user1.getUrl());

        // Проверка связанных данных
        assertEquals("Topic", topic1.getType());
        assertEquals(20, topic1.getLinkedId().intValue());
        assertEquals("Anime", topic1.getLinkedType());

        Anime linkedAnime1 = topic1.getLinked();
        assertEquals(20, linkedAnime1.getId().intValue());
        assertEquals("Naruto", linkedAnime1.getName());
        assertEquals("Наруто", linkedAnime1.getRussian());
        assertNotNull(linkedAnime1.getImage());
        assertEquals("/system/animes/original/20.jpg?1711965679", linkedAnime1.getImage().getOriginal());
        assertEquals("/system/animes/preview/20.jpg?1711965679", linkedAnime1.getImage().getPreview());
        assertEquals("/system/animes/x96/20.jpg?1711965679", linkedAnime1.getImage().getX96());
        assertEquals("/system/animes/x48/20.jpg?1711965679", linkedAnime1.getImage().getX48());
        assertEquals("/animes/z20-naruto", linkedAnime1.getUrl());
        assertEquals("tv", linkedAnime1.getKind());
        assertEquals("released", linkedAnime1.getStatus());
        assertEquals(220, linkedAnime1.getEpisodes().intValue());
        assertEquals(0, linkedAnime1.getEpisodesAired().intValue());
        assertEquals(LocalDate.parse("2002-10-03").toString(), linkedAnime1.getAiredOn());
        assertEquals(LocalDate.parse("2007-02-08").toString(), linkedAnime1.getReleasedOn());

        // Проверка второго топика
        Topic topic2 = topics.get(1);
        assertEquals(263434, topic2.getId().intValue());
        assertEquals("почему не включаются видосы с субтитрами", topic2.getTopicTitle());
        assertNotNull(topic2.getBody());
        assertNotNull(topic2.getHtmlBody());
        assertEquals("", topic2.getHtmlFooter());
        assertTrue(topic2.getCreatedAt().contains(LocalDateTime.parse("2018-10-06T09:26:54.285+03:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toString()));
        assertEquals(0, topic2.getCommentsCount().intValue());

        // Проверка форума
        Forum forum2 = topic2.getForum();
        assertEquals(8, forum2.getId().intValue());
        assertEquals(8, forum2.getPosition().intValue());
        assertEquals("Оффтопик", forum2.getName());
        assertEquals("offtopic", forum2.getPermalink());
        assertEquals("/forum/offtopic", forum2.getUrl());

        // Проверка пользователя
        User user2 = topic2.getUser();
        assertEquals(116183, user2.getId().intValue());
        assertEquals("悟 藤沼", user2.getNickname());
        assertEquals("https://desu.shikimori.one/system/users/x48/116183.png?1475599555", user2.getAvatar());
        assertNotNull(user2.getImage());
        assertNull(user2.getImage().getOriginal());
        assertNull(user2.getImage().getPreview());
        assertNull(user2.getImage().getX96());
        assertEquals("https://desu.shikimori.one/system/users/x48/116183.png?1475599555", user2.getImage().getX48());
        assertEquals("https://shikimori.one/%E6%82%9F+%E8%97%A4%E6%B2%BC", user2.getUrl());

        // Проверка связанных данных
        assertEquals("Topic", topic2.getType());
        assertEquals(20, topic2.getLinkedId().intValue());
        assertEquals("Anime", topic2.getLinkedType());

        Anime linkedAnime2 = topic2.getLinked();
        assertEquals(20, linkedAnime2.getId().intValue());
        assertEquals("Naruto", linkedAnime2.getName());
        assertEquals("Наруто", linkedAnime2.getRussian());
        assertNotNull(linkedAnime2.getImage());
        assertEquals("/system/animes/original/20.jpg?1711965679", linkedAnime2.getImage().getOriginal());
        assertEquals("/system/animes/preview/20.jpg?1711965679", linkedAnime2.getImage().getPreview());
        assertEquals("/system/animes/x96/20.jpg?1711965679", linkedAnime2.getImage().getX96());
        assertEquals("/system/animes/x48/20.jpg?1711965679", linkedAnime2.getImage().getX48());
        assertEquals("/animes/z20-naruto", linkedAnime2.getUrl());
        assertEquals("tv", linkedAnime2.getKind());
        assertEquals("released", linkedAnime2.getStatus());
        assertEquals(220, linkedAnime2.getEpisodes().intValue());
        assertEquals(0, linkedAnime2.getEpisodesAired().intValue());
        assertEquals(LocalDate.parse("2002-10-03").toString(), linkedAnime2.getAiredOn());
        assertEquals(LocalDate.parse("2007-02-08").toString(), linkedAnime2.getReleasedOn());
    }
}