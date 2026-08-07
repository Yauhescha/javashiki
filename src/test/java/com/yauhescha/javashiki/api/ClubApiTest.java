package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Club;
import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.Manga;
import com.yauhescha.javashiki.model.domen.Character;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.ClubImage;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ClubApiTest extends CommonTestData {

    @Test
    public void getClubs() {
        List<Club> clubs = clubApi.getClubs(1, 5, null);
        assertNotNull(clubs);
        assertFalse(clubs.isEmpty());
    }

    @Test
    public void getClubsWithSearch() {
        List<Club> clubs = clubApi.getClubs(1, 5, "anime");
        assertNotNull(clubs);
    }

    @Test
    public void getClub() {
        Optional<Club> club = clubApi.getClub(1093);
        assertTrue(club.isPresent());
        assertNotNull(club.get().getName());
    }

    @Test
    public void getClubAnimes() {
        List<Anime> animes = clubApi.getClubAnimes(1093, 1, 5);
        assertNotNull(animes);
    }

    @Test
    public void getClubMangas() {
        List<Manga> mangas = clubApi.getClubMangas(1093, 1, 5);
        assertNotNull(mangas);
    }

    @Test
    public void getClubCharacters() {
        List<Character> characters = clubApi.getClubCharacters(1093, 1, 5);
        assertNotNull(characters);
    }

    @Test
    public void getClubMembers() {
        List<User> members = clubApi.getClubMembers(1093, 1, 5);
        assertNotNull(members);
    }

    @Test
    public void getClubImages() {
        List<ClubImage> images = clubApi.getClubImages(1093, 1, 5);
        assertNotNull(images);
    }
}
