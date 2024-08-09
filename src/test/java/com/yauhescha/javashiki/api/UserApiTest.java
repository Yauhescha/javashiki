package com.yauhescha.javashiki.api;


import com.yauhescha.javashiki.constant.MessageType;
import com.yauhescha.javashiki.model.domen.AnimeMangaRate;
import com.yauhescha.javashiki.model.domen.Ban;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.message.Message;
import com.yauhescha.javashiki.model.domen.user.Club;
import com.yauhescha.javashiki.model.domen.user.Favourity;
import com.yauhescha.javashiki.model.domen.user.FavourityItem;
import com.yauhescha.javashiki.model.domen.user.History;
import com.yauhescha.javashiki.model.domen.user.UnreadMessages;
import com.yauhescha.javashiki.model.domen.user.UserFull;
import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.model.reques.AnimeMangaRateParameters;
import com.yauhescha.javashiki.model.reques.UserMessageParameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class UserApiTest extends CommonTestData {

    @Test
    public void getUsersWithParams() {
        List<User> users = userApi.getUsers(1, 1, TEST_USER_USERNAME);
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
        User user = users.get(0);
        Assert.assertEquals(TEST_USER_USERNAME, user.getNickname());
        Assert.assertEquals(TEST_USER_URL, user.getUrl());
    }

    @Test
    public void getUsers() {
        List<User> users = userApi.getUsers();
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() > 1);
    }

    @Test
    public void findUserById() {
        Optional<UserFull> userById = userApi.findUserById(TEST_USER_ID);
        Assert.assertTrue(userById.isPresent());
        UserFull user = userById.get();
        Assert.assertEquals(TEST_USER_USERNAME, user.getNickname());
        Assert.assertEquals("male", user.getSex());
        Assert.assertEquals("website", user.getWebsite());
        Assert.assertEquals(false, user.getBanned());
        Assert.assertEquals(1436833, user.getStyleId(), 0);
        Assert.assertEquals(TEST_USER_ID, user.getId(), 0);
    }

    @Test
    public void findUserInfo() {
        Optional<UserInfo> userInfo = userApi.findUserInfo(TEST_USER_ID);
        Assert.assertTrue(userInfo.isPresent());
        UserInfo info = userInfo.get();
        Assert.assertEquals(TEST_USER_URL, info.getUrl());
        Assert.assertEquals(TEST_USER_ID, info.getId(), 0);
        Assert.assertEquals("male", info.getSex());
        Assert.assertEquals(TEST_USER_USERNAME, info.getNickname());
        Assert.assertEquals("website", info.getWebsite());
        Assert.assertEquals("ru", info.getLocale());
    }

    @Test
    public void findUnreadMessages() {
        Optional<UnreadMessages> unreadMessages = userApi.findUnreadMessages(TEST_USER_ID);
        Assert.assertTrue(unreadMessages.isPresent());
        UnreadMessages messages = unreadMessages.get();
        throw new UnsupportedOperationException("Not supported yet (need ask administrators for access).");
    }

    @Test
    public void whoIAm() {
        UserInfo info = userApi.whoIAm();
        Assert.assertEquals(TEST_USER_URL, info.getUrl());
        Assert.assertEquals(TEST_USER_ID, info.getId(), 0);
        Assert.assertEquals("male", info.getSex());
        Assert.assertEquals(TEST_USER_USERNAME, info.getNickname());
        Assert.assertEquals("website", info.getWebsite());
        Assert.assertEquals("ru", info.getLocale());
    }

    @Test
    public void getBans() {
        List<Ban> bans = userApi.getBans(TEST_USER_ID);
        Assert.assertNotNull(bans);
        Assert.assertTrue(bans.isEmpty());
    }

    @Test
    public void getClubs() {
        List<Club> clubs = userApi.getClubs(TEST_USER_ID);
        Assert.assertNotNull(clubs);
        Assert.assertEquals(1, clubs.size());
        Club club = clubs.get(0);
        Assert.assertEquals(1093, club.getId(), 0);
        Assert.assertEquals("FAQ - Часто задаваемые вопросы", club.getName());
        Assert.assertEquals("free", club.getJoinPolicy());
        Assert.assertEquals("free", club.getCommentPolicy());
    }

    @Test
    public void getHistories() {
        List<History> histories = userApi.getHistories(TEST_USER_ID);
        Assert.assertNotNull(histories);
        Assert.assertFalse(histories.isEmpty());
        History history = histories.get(0);
        Assert.assertTrue(history.getId() > 1_000_000);
    }

    @Test
    public void getFavourities() {
        Favourity favourities = userApi.getFavourities(TEST_USER_ID);
        Assert.assertNotNull(favourities);

        List<FavourityItem> animes = favourities.getAnimes();
        Assert.assertFalse(animes.isEmpty());
        FavourityItem favourityAnime = animes.get(0);
        Assert.assertEquals("Наруто: Ураганные хроники", favourityAnime.getRussian());

        List<FavourityItem> mangas = favourities.getMangas();
        Assert.assertFalse(mangas.isEmpty());
        FavourityItem favourityManga = mangas.get(0);
        Assert.assertEquals("Поднятие уровня в одиночку", favourityManga.getRussian());

        List<FavourityItem> ranober = favourities.getRanobe();
        Assert.assertFalse(ranober.isEmpty());
        FavourityItem favourityRanobe = ranober.get(0);
        Assert.assertEquals("Этот замечательный мир!", favourityRanobe.getRussian());

        List<FavourityItem> characters = favourities.getCharacters();
        Assert.assertFalse(characters.isEmpty());
        FavourityItem favourityCharacter = characters.get(0);
        Assert.assertEquals("Мэгумин", favourityCharacter.getRussian());

        List<FavourityItem> favouritiesSeyus = favourities.getSeyu();
        Assert.assertFalse(favouritiesSeyus.isEmpty());
        FavourityItem favouritySeyu = favouritiesSeyus.get(0);
        Assert.assertEquals("Риэ Такахаси", favouritySeyu.getRussian());

        List<FavourityItem> favouritiesPeople = favourities.getPeople();
        Assert.assertFalse(favouritiesPeople.isEmpty());
        FavourityItem favourityPerson = favouritiesPeople.get(0);
        Assert.assertEquals("Аюму Хосино", favourityPerson.getRussian());

        List<FavourityItem> favouritiesMangakas = favourities.getMangakas();
        Assert.assertFalse(favouritiesMangakas.isEmpty());
        FavourityItem favourityMangaka = favouritiesMangakas.get(0);
        Assert.assertEquals("Хирохико Араки", favourityMangaka.getRussian());
    }

    @Test
    public void getFriends() {
        List<User> friends = userApi.getFriends(TEST_USER_ID);
        Assert.assertNotNull(friends);
        Assert.assertFalse(friends.isEmpty());
        User user = friends.get(0);
        Assert.assertEquals("Wesen", user.getNickname());
        Assert.assertEquals("https://shikimori.one/Wesen", user.getUrl());
    }

    @Test
    public void getAnimeRates() {
        List<AnimeMangaRate> animeRates = userApi.getAnimeRates(TEST_USER_ID, AnimeMangaRateParameters.builder().build());
        Assert.assertNotNull(animeRates);
        AnimeMangaRate rate = animeRates.get(0);
        Assert.assertEquals("watching", rate.getStatus());
        Assert.assertEquals(10, rate.getScore(), 0);
        Assert.assertEquals(3, rate.getEpisodes(), 0);
    }

    @Test
    public void getMangaRates() {
        List<AnimeMangaRate> animeRates = userApi.getMangaRates(TEST_USER_ID, AnimeMangaRateParameters.builder().build());
        Assert.assertNotNull(animeRates);
        AnimeMangaRate rate = animeRates.get(0);
        Assert.assertEquals("watching", rate.getStatus());
        Assert.assertEquals(9, rate.getScore(), 0);
        Assert.assertEquals(5, rate.getChapters(), 0);
    }

    @Test
    public void getMessages() {
        UserMessageParameters parameters = UserMessageParameters.builder().page(1).limit(1).type(MessageType.INBOX).build();
        List<Message> messages = userApi.getMessages(TEST_USER_ID, parameters);
        Assert.assertNotNull(messages);
        throw new UnsupportedOperationException("Not supported yet (need ask administrators for access).");
    }
}