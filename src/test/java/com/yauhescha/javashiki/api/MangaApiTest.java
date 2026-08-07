package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Manga;
import com.yauhescha.javashiki.model.domen.MangaFull;
import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.reques.MangaSearchParameters;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class MangaApiTest extends CommonTestData {

    @Test
    public void searchManga() {
        MangaSearchParameters parameters = MangaSearchParameters.builder()
                .search("naruto")
                .build();
        List<Manga> mangas = mangaApi.searchManga(parameters);
        assertFalse(mangas.isEmpty());
        Manga manga = mangas.get(0);
        assertNotNull(manga.getName());
    }

    @Test
    public void getMangaDetail() {
        Optional<MangaFull> mangaDetail = mangaApi.getMangaDetail(11);
        assertTrue(mangaDetail.isPresent());
        MangaFull manga = mangaDetail.get();
        assertEquals("Naruto", manga.getName());
        assertEquals("Наруто", manga.getRussian());
    }

    @Test
    public void getRoles() {
        List<Roles> roles = mangaApi.getRoles(11);
        assertNotNull(roles);
        assertFalse(roles.isEmpty());
    }

    @Test
    public void getSimilar() {
        List<Manga> similar = mangaApi.getSimilar(11);
        assertNotNull(similar);
    }

    @Test
    public void getRelated() {
        List<Related> related = mangaApi.getRelated(11);
        assertNotNull(related);
    }

    @Test
    public void getFranchise() {
        Optional<Franchise> franchise = mangaApi.getFranchise(11);
        assertTrue(franchise.isPresent());
    }

    @Test
    public void getExternalLinks() {
        List<ExternalLink> links = mangaApi.getExternalLinks(11);
        assertNotNull(links);
    }

    @Test
    public void getTopics() {
        List<Topic> topics = mangaApi.getTopics(11);
        assertNotNull(topics);
    }
}
