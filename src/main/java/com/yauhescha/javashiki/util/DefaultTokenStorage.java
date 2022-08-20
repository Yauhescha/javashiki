package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.auth.AccessToken;
import lombok.Data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Optional;

@Data
public final class DefaultTokenStorage {

    private static Path tokenPath = Paths.get("token.json");

    public static Optional<AccessToken> loadToken() {
        try {
            if (Files.isRegularFile(tokenPath)) {
                String fileText = Utils.readFileText(tokenPath);
                AccessToken token = Utils.fromJson(fileText, AccessToken.class);
                return Optional.ofNullable(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public static void saveToken(AccessToken token) {
        try {
            Files.write(tokenPath, Collections.singleton(Utils.toJson(token)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
