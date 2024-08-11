package com.yauhescha.javashiki;

import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.yauhescha.javashiki.constant.ShikiInfo.URL_SHIKIMORI;

public class TestingClass {

    public static void main(String[] args) {
        AuthShikimori auth = new AuthShikimori();

        Optional<AnimeFull> animeDetail = auth.getAnimeApi().getAnimeDetail(20, true);
        if (animeDetail.isPresent()) {
            AnimeFull anime = animeDetail.get();
            System.out.println(anime);
            List<Roles> roles = auth.getAnimeApi().getRoles(20, true);
            roles = roles.stream()
                .filter(roles1 -> !roles1.getCharacter().getImage().getOriginal().contains("assets/globals/missing/main"))
                .collect(Collectors.toList());
            try {
                saveAnimeDetails(anime, roles);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveAnimeDetails(AnimeFull anime, List<Roles> roles) throws IOException {
        String animeId = String.valueOf(anime.getMyanimelistId());
        Path animeDir = Paths.get(animeId);
        Path charactersDir = animeDir.resolve("characters");

        // Создаем папки
        Files.createDirectories(animeDir);
        Files.createDirectories(charactersDir);

//        // Сохраняем скриншоты
//        for (Screenshot screenshot : anime.getScreenshots()) {
//            saveImage(screenshot.getOriginal(), animeDir.resolve(getFileName(screenshot.getOriginal().substring(0, screenshot.getOriginal().lastIndexOf("?")))));
//        }
//
//        // Сохраняем картинки персонажей
//        for (Roles role : roles) {
//            Character character = role.getCharacter();
//            if (character != null) {
//                saveImage(character.getImage().getOriginal(), charactersDir.resolve(character.getId() + ".jpg"));
//            }
//        }

        // Сериализуем и сохраняем объект Roles в файл
        saveRolesToFile(roles, charactersDir.resolve("roles.ser"));
    }

    public static void saveImage(String imageUrl, Path destination) throws IOException {
        try (InputStream in = new URL(URL_SHIKIMORI + imageUrl).openStream()) {
            Files.copy(in, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void saveRolesToFile(List<Roles> roles, Path filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
            oos.writeObject(roles);
        }
    }

    private static String getFileName(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }

    private static void printList(List<?> list) {
        System.out.println("before printing");
        list.forEach(System.out::println);
        System.out.println("afterPrinting");
    }
}
