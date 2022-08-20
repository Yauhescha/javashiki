package com.yauhescha.javashiki.util;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.model.auth.AccessToken;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Scanner;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;

//TODO remove comment
public class AuthShiki {
//    String defaultLogin = "fpo81406";
    private static final Scanner scanner = new Scanner(System.in);

    public AccessToken initialAccessToken() throws Exception {
        AccessToken accessToken;
        Optional<AccessToken> maybeToken = DefaultTokenStorage.loadToken();
        if (maybeToken.isEmpty()) {
            System.out.println("Need to new access token");
            showAuthorizationCode();
            accessToken = getAuthorization();
        } else {
            accessToken = maybeToken.get();
        }

        return accessToken;
    }

    private AccessToken getAuthorization() throws Exception {
        System.out.println("Please write code\n");
        final String APPLICATION_AUTHORIZATION_CODE = scanner.nextLine();
        HttpRequest tokenRequest = AuthMethodCreator.createAuthorizationTokenRequest(APPLICATION_CLIENT_ID,
                APPLICATION_CLIENT_SECRET, APPLICATION_REDIRECT_URI, APPLICATION_AUTHORIZATION_CODE, APPLICATION_NAME);
        AccessToken accessToken = Utils.fromJson(tokenRequest.body(), AccessToken.class);
        DefaultTokenStorage.saveToken(accessToken);
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
