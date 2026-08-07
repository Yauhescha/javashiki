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

public class RanobeApiTest extends CommonTestData {

    @Test
    public void getRanobe() {
        MangaSearchParameters parameters = MangaSearchParameters.builder()
                .search("haruhi")
                .kind(com.yauhescha.javashiki.constant.search.SearchMangaKind.LIGHT_NOVEL)
                .build();
        List<Manga> ranobe = ranobeApi.getRanobe(parameters);
        assertNotNull(ranobe);
    }

    @Test
    public void getRanobeDetail() {
        Optional<MangaFull> detail = ranobeApi.getRanobeDetail(103);
        assertNotNull(detail);
    }

    @Test
    public void getRoles() {
        List<Roles> roles = ranobeApi.getRoles(103);
        assertNotNull(roles);
    }

    @Test
    public void getSimilar() {
        List<Manga> similar = ranobeApi.getSimilar(103);
        assertNotNull(similar);
    }

    @Test
    public void getRelated() {
        List<Related> related = ranobeApi.getRelated(103);
        assertNotNull(related);
    }

    @Test
    public void getFranchise() {
        Optional<Franchise> franchise = ranobeApi.getFranchise(103);
        assertNotNull(franchise);
    }

    @Test
    public void getExternalLinks() {
        List<ExternalLink> links = ranobeApi.getExternalLinks(103);
        assertNotNull(links);
    }

    @Test
    public void getTopics() {
        List<Topic> topics = ranobeApi.getTopics(103);
        assertNotNull(topics);
    }
}
