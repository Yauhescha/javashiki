package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.constant.search.SearchAnimeKind;
import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import org.junit.Test;

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
        assertNotNull(anime.getName());
        assertEquals("movie", anime.getKind());
    }

    @Test
    public void getAnimeDetail() {
        Optional<AnimeFull> animeDetail = animeApi.getAnimeDetail(20, false);
        assertTrue(animeDetail.isPresent());
        AnimeFull anime = animeDetail.get();

        assertEquals("Naruto", anime.getName());
        assertEquals("Наруто", anime.getRussian());
        assertEquals("released", anime.getStatus());
        assertEquals(220, anime.getEpisodes().longValue());
        assertEquals("tv", anime.getKind());
        assertEquals("pg_13", anime.getRating());
        assertEquals("naruto", anime.getFranchise());
        assertFalse(anime.getFavoured());
        assertFalse(anime.getAnons());
        assertFalse(anime.getOngoing());
        assertNotNull(anime.getGenres());
        assertNotNull(anime.getStudios());
    }

    @Test
    public void getScreenshots() {
        List<Screenshot> screenshots = animeApi.getScreenshots(20);
        assertFalse(screenshots.isEmpty());
        Screenshot screenshot1 = screenshots.get(0);
        assertNotNull(screenshot1.getOriginal());
        assertNotNull(screenshot1.getPreview());
    }

    @Test
    public void getRoles() {
        List<Roles> roles = animeApi.getRoles(20, true);
        assertFalse(roles.isEmpty());
        Roles role1 = roles.get(0);
        assertNotNull(role1.getRoles());
        assertNotNull(role1.getCharacter());
    }

    @Test
    public void getSimilar() {
        List<Anime> similar = animeApi.getSimilar(20);
        assertNotNull(similar);
        assertFalse(similar.isEmpty());
    }

    @Test
    public void getRelated() {
        List<Related> related = animeApi.getRelated(20);
        assertNotNull(related);
        assertFalse(related.isEmpty());
        Related related1 = related.get(0);
        assertNotNull(related1.getRelation());
        assertNotNull(related1.getRelationRussian());
    }

    @Test
    public void getExternalLinks() {
        List<ExternalLink> externalLinks = animeApi.getExternalLinks(20);
        assertFalse(externalLinks.isEmpty());
        ExternalLink link1 = externalLinks.get(0);
        assertNotNull(link1.getKind());
        assertNotNull(link1.getUrl());
    }

    @Test
    public void getFranchise() {
        Optional<Franchise> franchiseOptional = animeApi.getFranchise(20);
        assertTrue(franchiseOptional.isPresent());
        Franchise franchise = franchiseOptional.get();
        assertNotNull(franchise.getLinks());
        assertNotNull(franchise.getNodes());
        assertEquals(20, franchise.getCurrentId().intValue());
    }

    @Test
    public void getTopics() {
        List<Topic> topics = animeApi.getTopics(20);
        assertNotNull(topics);
        if (!topics.isEmpty()) {
            Topic topic1 = topics.get(0);
            assertNotNull(topic1.getTopicTitle());
            assertNotNull(topic1.getForum());
        }
    }
}
