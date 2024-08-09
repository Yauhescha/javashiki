package com.yauhescha.javashiki.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.api.AchievementApi;
import com.yauhescha.javashiki.api.AnimeApi;
import com.yauhescha.javashiki.api.AppearsApi;
import com.yauhescha.javashiki.api.BanApi;
import com.yauhescha.javashiki.api.CalendarApi;
import com.yauhescha.javashiki.api.CharacterApi;
import com.yauhescha.javashiki.api.ConstantApi;
import com.yauhescha.javashiki.api.ForumApi;
import com.yauhescha.javashiki.api.GenreApi;
import com.yauhescha.javashiki.api.MangaApi;
import com.yauhescha.javashiki.api.PeopleApi;
import com.yauhescha.javashiki.api.PublisherApi;
import com.yauhescha.javashiki.api.StatsApi;
import com.yauhescha.javashiki.api.StudioApi;
import com.yauhescha.javashiki.api.UserApi;
import com.yauhescha.javashiki.api.UserImageApi;
import com.yauhescha.javashiki.model.auth.AccessToken;
import com.yauhescha.javashiki.util.AuthMethodCreator;
import com.yauhescha.javashiki.util.Utils;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Getter
public class AuthShikimori {
    private final AnimeApi animeApi = new AnimeApi(this);
    private final AppearsApi appearsApi = new AppearsApi(this);
    private final AchievementApi achievementApi = new AchievementApi(this);
    private final BanApi banApi = new BanApi(this);
    private final CalendarApi calendarApi = new CalendarApi(this);
    private final CharacterApi characterApi = new CharacterApi(this);
    private final ConstantApi constantApi = new ConstantApi(this);
    private final ForumApi forumApi = new ForumApi(this);
    private final GenreApi genreApi = new GenreApi(this);
    private final MangaApi mangaApi = new MangaApi(this);
    private final PeopleApi peopleApi = new PeopleApi(this);
    private final PublisherApi publisherApi = new PublisherApi(this);
    private final StatsApi statsApi = new StatsApi(this);
    private final StudioApi studioApi = new StudioApi(this);
    private final UserApi userApi = new UserApi(this);
    private final UserImageApi userImageApi = new UserImageApi(this);

    private final String applicationName;
    private final String applicationClientId;
    private final String applicationClientSecret;
    private final String applicationRedirectUri;

    private AccessToken accessToken;

    public AuthShikimori() {
        this.applicationName = "Api Test";
        this.applicationClientId = "bce7ad35b631293ff006be882496b29171792c8839b5094115268da7a97ca34c";
        this.applicationClientSecret = "811459eada36b14ff0cf0cc353f8162e72a7d6e6c7930b647a5c587d1beffe68";
        this.applicationRedirectUri = "urn:ietf:wg:oauth:2.0:oob";
        AccessToken token = readTokenIfExist();
        if (token != null) {
            this.accessToken = token;
        }
    }

    public AuthShikimori(String applicationName,
                         String applicationClientId,
                         String applicationClientSecret,
                         String applicationRedirectUri) {
        this.applicationName = applicationName;
        this.applicationClientId = applicationClientId;
        this.applicationClientSecret = applicationClientSecret;
        this.applicationRedirectUri = applicationRedirectUri;
    }

    public String getUrlToAuthorizationCode() {
        return AuthMethodCreator.createAuthorizationLink(applicationClientId,
            applicationClientSecret, applicationRedirectUri);
    }

    public void authorize(String authorizationCode) {
        HttpRequest tokenRequest = AuthMethodCreator.createAuthorizationTokenRequest(applicationClientId,
            applicationClientSecret, applicationRedirectUri, authorizationCode, applicationName);
        String body = tokenRequest.body();
        saveToken(body);
        this.accessToken = Utils.fromJson(body, AccessToken.class);
    }

    public void refreshToken() {
        HttpRequest tokenRequest = AuthMethodCreator.createRefreshTokenRequest(applicationClientId,
            applicationClientSecret, applicationName, accessToken.getRefreshToken());
        String body = tokenRequest.body();
        saveToken(body);
        this.accessToken = Utils.fromJson(body, AccessToken.class);
    }

    public void refreshToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    private void saveToken(String text) {
        try (FileWriter writer = new FileWriter("AccessToken", false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public AccessToken readTokenIfExist() {
        try (BufferedReader reader = new BufferedReader(new FileReader("AccessToken"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return Utils.fromJson(sb.toString(), AccessToken.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
