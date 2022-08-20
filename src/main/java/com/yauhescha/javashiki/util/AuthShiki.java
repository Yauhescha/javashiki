package com.yauhescha.javashiki.util;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.model.auth.AccessToken;
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

public class AuthShiki {
//TODO remove comment
    //String defaultLogin = "fpo81406";
    private static final Scanner scanner = new Scanner(System.in);

    @Getter
    private AccessToken accessToken;

    public AccessToken initialAccessToken() throws Exception {
        return initialAccessToken(null);
    }

    public AccessToken initialAccessToken(String authorizationCode) throws Exception {
        AccessToken accessToken;
        Optional<AccessToken> maybeToken = DefaultTokenStorage.loadToken();
        if (maybeToken.isEmpty()) {
            System.out.println("Need new access token");
            showAuthorizationCode();
            accessToken = getAuthorization(authorizationCode);
        } else {
            accessToken = maybeToken.get();
        }

        return accessToken;
    }

    private AccessToken getAuthorization(String code) throws Exception {
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

    private void showAuthorizationCode() throws URISyntaxException {
        URI url = AuthMethodCreator.createCodeRequest(APPLICATION_CLIENT_ID,
                APPLICATION_CLIENT_SECRET, APPLICATION_REDIRECT_URI).url().toURI();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.toString());
    }

}
