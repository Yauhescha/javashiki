package com.yauhescha.javashiki;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AnimeReader {

    public static void main(String[] args) {
        try {
            Path filePath = Paths.get("20", "characters", "roles.ser");
            List<Roles> roles = readRolesFromFile(filePath);

            // Пример вывода прочитанных данных
            for (Roles role : roles) {
                System.out.println(role);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Roles> readRolesFromFile(Path filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
            return (List<Roles>) ois.readObject();
        }
    }
}

// Классы-заглушки для компиляции кода. Замените их на реальные классы из библиотеки javashiki.
class Roles implements Serializable {
    // Ваши поля и методы здесь

    @Override
    public String toString() {
        // Ваш метод toString для вывода данных
        return "Roles{}";
    }
}

