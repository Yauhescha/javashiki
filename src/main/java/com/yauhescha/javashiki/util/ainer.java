package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.MangaApi;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.reques.MangaTopicParameters;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

public class ainer {
    public static void main(String[] args) {

        final MangaApi api = new AuthShikimori().getMangaApi();
        final List<Topic> topics = api.getTopics(1);
        final List<Topic> topics1 = api.getTopics(1, MangaTopicParameters.builder()
                .limit(1)
                .page(2)
                .build());

        System.out.println(api.getExternalLinks(1));

    }
}
