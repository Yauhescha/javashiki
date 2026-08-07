package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.request.AuthShikimori;
import org.junit.Before;

public class CommonTestData {
    public static final int TEST_USER_ID = 1501051;
    public static final String TEST_USER_USERNAME = "javashiki";
    public static final String TEST_USER_URL = "https://shikimori.io/javashiki";

    protected final AuthShikimori authShikimori = new AuthShikimori();
    protected final AnimeApi animeApi = authShikimori.getAnimeApi();
    protected final AppearsApi appearsApi = authShikimori.getAppearsApi();
    protected final AchievementApi achievementApi = authShikimori.getAchievementApi();
    protected final BanApi banApi = authShikimori.getBanApi();
    protected final CalendarApi calendarApi = authShikimori.getCalendarApi();
    protected final CharacterApi characterApi = authShikimori.getCharacterApi();
    protected final ClubApi clubApi = authShikimori.getClubApi();
    protected final CommentApi commentApi = authShikimori.getCommentApi();
    protected final ConstantApi constantApi = authShikimori.getConstantApi();
    protected final DialogApi dialogApi = authShikimori.getDialogApi();
    protected final FavoriteApi favoriteApi = authShikimori.getFavoriteApi();
    protected final ForumApi forumApi = authShikimori.getForumApi();
    protected final FriendApi friendApi = authShikimori.getFriendApi();
    protected final GenreApi genreApi = authShikimori.getGenreApi();
    protected final MangaApi mangaApi = authShikimori.getMangaApi();
    protected final MessageApi messageApi = authShikimori.getMessageApi();
    protected final PeopleApi peopleApi = authShikimori.getPeopleApi();
    protected final PublisherApi publisherApi = authShikimori.getPublisherApi();
    protected final RanobeApi ranobeApi = authShikimori.getRanobeApi();
    protected final ReviewApi reviewApi = authShikimori.getReviewApi();
    protected final StatsApi statsApi = authShikimori.getStatsApi();
    protected final StudioApi studioApi = authShikimori.getStudioApi();
    protected final StyleApi styleApi = authShikimori.getStyleApi();
    protected final TopicApi topicApi = authShikimori.getTopicApi();
    protected final UserApi userApi = authShikimori.getUserApi();
    protected final UserImageApi userImageApi = authShikimori.getUserImageApi();
    protected final UserRateApi userRateApi = authShikimori.getUserRateApi();
    protected final VideoApi videoApi = authShikimori.getVideoApi();

    @Before
    public void setUpBeforeClass() throws Exception {
        Thread.sleep(1000);
    }
}
