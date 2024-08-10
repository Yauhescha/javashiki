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
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserApiTest extends CommonTestData {

    @Test
    public void getUsersWithParams() {
        List<User> users = userApi.getUsers(1, 1, TEST_USER_USERNAME);
        assertNotNull(users);
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals(TEST_USER_USERNAME, user.getNickname());
        assertEquals(TEST_USER_URL, user.getUrl());
    }

    @Test
    public void getUsers() {
        List<User> users = userApi.getUsers();
        assertNotNull(users);
        assertTrue(users.size() > 1);
    }

    @Test
    public void findUserById() {
        Optional<UserFull> userById = userApi.findUserById(TEST_USER_ID);
        assertTrue(userById.isPresent());
        UserFull user = userById.get();
        assertEquals(TEST_USER_USERNAME, user.getNickname());
        assertEquals("male", user.getSex());
        assertEquals("website", user.getWebsite());
        assertEquals(false, user.getBanned());
        assertEquals(1436833, user.getStyleId(), 0);
        assertEquals(TEST_USER_ID, user.getId(), 0);
    }

    @Test
    public void findUserInfo() {
        Optional<UserInfo> userInfo = userApi.findUserInfo(TEST_USER_ID);
        assertTrue(userInfo.isPresent());
        UserInfo info = userInfo.get();
        assertEquals(TEST_USER_URL, info.getUrl());
        assertEquals(TEST_USER_ID, info.getId(), 0);
        assertEquals("male", info.getSex());
        assertEquals(TEST_USER_USERNAME, info.getNickname());
        assertEquals("website", info.getWebsite());
        assertEquals("ru", info.getLocale());
    }

    @Test
    public void findUnreadMessages() {
        Optional<UnreadMessages> unreadMessages = userApi.findUnreadMessages(TEST_USER_ID);
        assertTrue(unreadMessages.isPresent());
        UnreadMessages messages = unreadMessages.get();
        throw new UnsupportedOperationException("Not supported yet (need ask administrators for access).");
    }

    @Test
    public void whoIAm() {
        UserInfo info = userApi.whoIAm();
        assertEquals(TEST_USER_URL, info.getUrl());
        assertEquals(TEST_USER_ID, info.getId(), 0);
        assertEquals("male", info.getSex());
        assertEquals(TEST_USER_USERNAME, info.getNickname());
        assertEquals("website", info.getWebsite());
        assertEquals("ru", info.getLocale());
    }

    @Test
    public void getBans() {
        List<Ban> bans = userApi.getBans(TEST_USER_ID);
        assertNotNull(bans);
        assertTrue(bans.isEmpty());
    }

    @Test
    public void getClubs() {
        List<Club> clubs = userApi.getClubs(TEST_USER_ID);
        assertNotNull(clubs);
        assertEquals(1, clubs.size());
        Club club = clubs.get(0);
        assertEquals(1093, club.getId(), 0);
        assertEquals("FAQ - Часто задаваемые вопросы", club.getName());
        assertEquals("free", club.getJoinPolicy());
        assertEquals("free", club.getCommentPolicy());
    }

    @Test
    public void getHistories() {
        List<History> histories = userApi.getHistories(TEST_USER_ID);
        assertNotNull(histories);
        assertFalse(histories.isEmpty());
        History history = histories.get(0);
        assertTrue(history.getId() > 1_000_000);
    }

    @Test
    public void getFavourities() {
        Favourity favourities = userApi.getFavourities(TEST_USER_ID);
        assertNotNull(favourities);

        List<FavourityItem> animes = favourities.getAnimes();
        assertFalse(animes.isEmpty());
        FavourityItem favourityAnime = animes.get(0);
        assertEquals("Наруто: Ураганные хроники", favourityAnime.getRussian());

        List<FavourityItem> mangas = favourities.getMangas();
        assertFalse(mangas.isEmpty());
        FavourityItem favourityManga = mangas.get(0);
        assertEquals("Поднятие уровня в одиночку", favourityManga.getRussian());

        List<FavourityItem> ranober = favourities.getRanobe();
        assertFalse(ranober.isEmpty());
        FavourityItem favourityRanobe = ranober.get(0);
        assertEquals("Этот замечательный мир!", favourityRanobe.getRussian());

        List<FavourityItem> characters = favourities.getCharacters();
        assertFalse(characters.isEmpty());
        FavourityItem favourityCharacter = characters.get(0);
        assertEquals("Мэгумин", favourityCharacter.getRussian());

        List<FavourityItem> favouritiesSeyus = favourities.getSeyu();
        assertFalse(favouritiesSeyus.isEmpty());
        FavourityItem favouritySeyu = favouritiesSeyus.get(0);
        assertEquals("Риэ Такахаси", favouritySeyu.getRussian());

        List<FavourityItem> favouritiesPeople = favourities.getPeople();
        assertFalse(favouritiesPeople.isEmpty());
        FavourityItem favourityPerson = favouritiesPeople.get(0);
        assertEquals("Аюму Хосино", favourityPerson.getRussian());

        List<FavourityItem> favouritiesMangakas = favourities.getMangakas();
        assertFalse(favouritiesMangakas.isEmpty());
        FavourityItem favourityMangaka = favouritiesMangakas.get(0);
        assertEquals("Хирохико Араки", favourityMangaka.getRussian());
    }

    @Test
    public void getFriends() {
        List<User> friends = userApi.getFriends(TEST_USER_ID);
        assertNotNull(friends);
        assertFalse(friends.isEmpty());
        User user = friends.get(0);
        assertEquals("Wesen", user.getNickname());
        assertEquals("https://shikimori.one/Wesen", user.getUrl());
    }

    @Test
    public void getAnimeRates() {
        List<AnimeMangaRate> animeRates = userApi.getAnimeRates(TEST_USER_ID, AnimeMangaRateParameters.builder().build());
        assertNotNull(animeRates);
        AnimeMangaRate rate = animeRates.get(0);
        assertEquals("watching", rate.getStatus());
        assertEquals(10, rate.getScore(), 0);
        assertEquals(3, rate.getEpisodes(), 0);
    }

    @Test
    public void getMangaRates() {
        List<AnimeMangaRate> animeRates = userApi.getMangaRates(TEST_USER_ID, AnimeMangaRateParameters.builder().build());
        assertNotNull(animeRates);
        AnimeMangaRate rate = animeRates.get(0);
        assertEquals("watching", rate.getStatus());
        assertEquals(9, rate.getScore(), 0);
        assertEquals(5, rate.getChapters(), 0);
    }

    @Test
    public void getMessages() {
        UserMessageParameters parameters = UserMessageParameters.builder().page(1).limit(1).type(MessageType.INBOX).build();
        List<Message> messages = userApi.getMessages(TEST_USER_ID, parameters);
        assertNotNull(messages);
        throw new UnsupportedOperationException("Not supported yet (need ask administrators for access).");
    }
}