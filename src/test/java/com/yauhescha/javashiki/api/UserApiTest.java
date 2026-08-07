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

import static org.junit.Assert.*;

public class UserApiTest extends CommonTestData {

    @Test
    public void getUsersWithParams() {
        List<User> users = userApi.getUsers(1, 1, TEST_USER_USERNAME);
        assertNotNull(users);
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals(TEST_USER_USERNAME, user.getNickname());
        assertNotNull(user.getUrl());
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
        assertNotNull(user.getNickname());
        assertNotNull(user.getSex());
    }

    @Test
    public void findUserInfo() {
        Optional<UserInfo> userInfo = userApi.findUserInfo(TEST_USER_ID);
        assertTrue(userInfo.isPresent());
        UserInfo info = userInfo.get();
        assertEquals(TEST_USER_ID, info.getId(), 0);
        assertNotNull(info.getNickname());
        assertNotNull(info.getSex());
        assertNotNull(info.getUrl());
    }

    @Test
    public void findUnreadMessages() {
        Optional<UnreadMessages> unreadMessages = userApi.findUnreadMessages(TEST_USER_ID);
        assertNotNull(unreadMessages);
    }

    @Test
    public void whoIAm() {
        UserInfo info = userApi.whoIAm();
        assertNotNull(info);
        assertNotNull(info.getId());
        assertNotNull(info.getNickname());
    }

    @Test
    public void getBans() {
        List<Ban> bans = userApi.getBans(TEST_USER_ID);
        assertNotNull(bans);
    }

    @Test
    public void getClubs() {
        List<Club> clubs = userApi.getClubs(TEST_USER_ID);
        assertNotNull(clubs);
        if (!clubs.isEmpty()) {
            Club club = clubs.get(0);
            assertNotNull(club.getName());
        }
    }

    @Test
    public void getHistories() {
        List<History> histories = userApi.getHistories(TEST_USER_ID);
        assertNotNull(histories);
    }

    @Test
    public void getFavourities() {
        Favourity favourities = userApi.getFavourities(TEST_USER_ID);
        assertNotNull(favourities);
        assertNotNull(favourities.getAnimes());
        assertNotNull(favourities.getMangas());
        assertNotNull(favourities.getCharacters());
    }

    @Test
    public void getFriends() {
        List<User> friends = userApi.getFriends(TEST_USER_ID);
        assertNotNull(friends);
    }

    @Test
    public void getAnimeRates() {
        List<AnimeMangaRate> animeRates = userApi.getAnimeRates(TEST_USER_ID, AnimeMangaRateParameters.builder().build());
        assertNotNull(animeRates);
    }

    @Test
    public void getMangaRates() {
        List<AnimeMangaRate> animeRates = userApi.getMangaRates(TEST_USER_ID, AnimeMangaRateParameters.builder().build());
        assertNotNull(animeRates);
    }

    @Test
    public void getMessages() {
        UserMessageParameters parameters = UserMessageParameters.builder().page(1).limit(1).type(MessageType.INBOX).build();
        List<Message> messages = userApi.getMessages(TEST_USER_ID, parameters);
        assertNotNull(messages);
    }
}
