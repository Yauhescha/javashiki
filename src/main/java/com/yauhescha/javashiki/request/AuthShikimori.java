package com.yauhescha.javashiki.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.api.AchievementApi;
import com.yauhescha.javashiki.api.AnimeApi;
import com.yauhescha.javashiki.api.AppearsApi;
import com.yauhescha.javashiki.api.BanApi;
import com.yauhescha.javashiki.api.CalendarApi;
import com.yauhescha.javashiki.api.ConstantApi;
import com.yauhescha.javashiki.api.ForumApi;
import com.yauhescha.javashiki.api.GenreApi;
import com.yauhescha.javashiki.api.PublisherApi;
import com.yauhescha.javashiki.api.StatsApi;
import com.yauhescha.javashiki.api.StudioApi;
import com.yauhescha.javashiki.api.UserImageApi;
import com.yauhescha.javashiki.model.auth.AccessToken;
import com.yauhescha.javashiki.util.AuthMethodCreator;
import com.yauhescha.javashiki.util.DefaultTokenStorage;
import com.yauhescha.javashiki.util.Utils;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Scanner;

import static com.yauhescha.javashiki.constant.ShikiInfo.APPLICATION_CLIENT_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.APPLICATION_CLIENT_SECRET;
import static com.yauhescha.javashiki.constant.ShikiInfo.APPLICATION_NAME;
import static com.yauhescha.javashiki.constant.ShikiInfo.APPLICATION_REDIRECT_URI;

@Getter
public class AuthShikimori {
    private static final Scanner scanner = new Scanner(System.in);

    private AccessToken accessToken;

    private final AnimeApi animeApi = new AnimeApi(this);

    private final AppearsApi appearsApi = new AppearsApi(this);

    private final AchievementApi achievementApi = new AchievementApi(this);

    private final BanApi banApi = new BanApi(this);

    private final CalendarApi calendarApi = new CalendarApi(this);

    private final ForumApi forumApi = new ForumApi(this);

    private final StudioApi studioApi = new StudioApi(this);

    private final GenreApi genreApi = new GenreApi(this);

    private final StatsApi statsApi = new StatsApi(this);

    private final PublisherApi publisherApi = new PublisherApi(this);

    private final ConstantApi constantApi = new ConstantApi(this);

    private final UserImageApi userImageApi = new UserImageApi(this);

//    private final PeopleApi peopleApi = new PeopleApi(this);

    public AuthShikimori() {
        initialAccessToken(null);
    }

    public AuthShikimori(String authorizationCode) {
        initialAccessToken(authorizationCode);
    }

    protected AccessToken initialAccessToken() {
        return initialAccessToken(null);
    }

    private AccessToken initialAccessToken(String authorizationCode) {
        AccessToken accessToken;
        Optional<AccessToken> maybeToken = DefaultTokenStorage.loadToken();
        if (maybeToken.isEmpty() || maybeToken.get().isRefreshRequired()) {
            System.out.println("Need new access token");
            showAuthorizationCode();
            accessToken = getAuthorization(authorizationCode);
        } else if (maybeToken.get().isRefreshRequired()) {
            accessToken = refreshToken();
        } else {
            accessToken = maybeToken.get();
        }
        this.accessToken = accessToken;
        return accessToken;
    }

    private AccessToken getAuthorization(String code) {
        if (code == null) {
            System.out.println("Please write code\n");
            code = scanner.nextLine();
        }
        HttpRequest tokenRequest = AuthMethodCreator.createAuthorizationTokenRequest(APPLICATION_CLIENT_ID,
                APPLICATION_CLIENT_SECRET, APPLICATION_REDIRECT_URI, code, APPLICATION_NAME);
        AccessToken accessToken = Utils.fromJson(tokenRequest.body(), AccessToken.class);
        DefaultTokenStorage.saveToken(accessToken);
        this.accessToken = accessToken;
        return accessToken;
    }

    private void showAuthorizationCode() {
        try {
            URI url = AuthMethodCreator.createCodeRequest(APPLICATION_CLIENT_ID,
                    APPLICATION_CLIENT_SECRET, APPLICATION_REDIRECT_URI).url().toURI();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public AccessToken refreshToken() {
        HttpRequest tokenRequest = AuthMethodCreator.createRefreshTokenRequest(APPLICATION_CLIENT_ID,
                APPLICATION_CLIENT_SECRET, APPLICATION_NAME, accessToken.getRefreshToken());
        AccessToken accessToken = Utils.fromJson(tokenRequest.body(), AccessToken.class);
        DefaultTokenStorage.saveToken(accessToken);
        this.accessToken = accessToken;
        return accessToken;
    }

}
