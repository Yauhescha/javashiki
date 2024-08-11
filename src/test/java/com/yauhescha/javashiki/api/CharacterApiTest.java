package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.AnimeForCharacter;
import com.yauhescha.javashiki.model.domen.CharacterFull;
import com.yauhescha.javashiki.model.domen.MangaForCharacter;
import com.yauhescha.javashiki.model.domen.Seyu;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CharacterApiTest extends CommonTestData{

    @Test
    public void findById() {
        Optional<CharacterFull> byId = characterApi.findById(809);
        assertTrue(byId.isPresent());
        CharacterFull character = byId.get();

        // Проверка основных полей
        assertEquals(809, character.getId().intValue());
        assertEquals("Anko Mitarashi", character.getName());
        assertEquals("Анко Митараши", character.getRussian());
        assertNotNull(character.getImage());
        assertEquals("/system/characters/original/809.jpg?1716844122", character.getImage().getOriginal());
        assertEquals("/system/characters/preview/809.jpg?1716844122", character.getImage().getPreview());
        assertEquals("/system/characters/x96/809.jpg?1716844122", character.getImage().getX96());
        assertEquals("/system/characters/x48/809.jpg?1716844122", character.getImage().getX48());
        assertEquals("/characters/809-anko-mitarashi", character.getUrl());
        assertEquals("Anko Mitarashi", character.getAltname());
        assertEquals("みたらし・アンコ", character.getJapanese());

        // Проверка описания
        String expectedDescription = "Куноити, родившаяся и выросшая в Деревне Скрытого Листа. Став ученицей одного из саннинов";
        assertTrue(character.getDescription().contains(expectedDescription));

        String expectedDescriptionHtml = "<div class=\"b-text_with_paragraphs\">Куноити, родившаяся и выросшая в Деревне Скрытого Листа. Став ученицей одного из саннинов, <a href=\"https://shikimori.one/characters/2455-orochimaru\" title=\"Orochimaru\" class=\"bubbled b-link\" data-tooltip_url";
        assertTrue(character.getDescriptionHtml().contains(expectedDescriptionHtml));

        assertEquals("http://ru.wikipedia.org/w/index.php?title=Список_персонажей_«Наруто»", character.getDescriptionSource());
        assertFalse(character.getFavoured());
        assertEquals(31900, character.getThreadId().intValue());
        assertEquals(31900, character.getTopicId().intValue());

        // Проверка сэйю
        List<Seyu> seyuList = character.getSeyu();

        Seyu seyu1 = seyuList.get(0);
        assertEquals(41, seyu1.getId().intValue());
        assertEquals("Takako Honda", seyu1.getName());
        assertEquals("Такако Хонда", seyu1.getRussian());
        assertNotNull(seyu1.getImage());
        assertEquals("/system/people/original/41.jpg?1717533024", seyu1.getImage().getOriginal());
        assertEquals("/system/people/preview/41.jpg?1717533024", seyu1.getImage().getPreview());
        assertEquals("/system/people/x96/41.jpg?1717533024", seyu1.getImage().getX96());
        assertEquals("/system/people/x48/41.jpg?1717533024", seyu1.getImage().getX48());
        assertEquals("/people/41-takako-honda", seyu1.getUrl());

        // Проверка аниме
        List<AnimeForCharacter> animes = character.getAnimes();
        AnimeForCharacter anime1 = animes.get(0);
        assertEquals("Supporting", anime1.getRoles().get(0));
        assertEquals("Supporting", anime1.getRole());

        // Проверка манги
        List<MangaForCharacter> mangas = character.getMangas();
        MangaForCharacter manga1 = mangas.get(0);
        assertEquals("Supporting", manga1.getRoles().get(0));
        assertEquals("Supporting", manga1.getRole());
    }


    @Test
    public void search() {
        List<CharacterFull> narutoList = characterApi.search("naruto uzumaki");
        assertFalse(narutoList.isEmpty());

        // Проверка первого результата поиска
        CharacterFull naruto = narutoList.get(0);
        assertEquals(17, naruto.getId().intValue());
        assertEquals("Naruto Uzumaki", naruto.getName());
        assertEquals("Наруто Узумаки", naruto.getRussian());
        assertNotNull(naruto.getImage());
        assertEquals("/system/characters/original/17.jpg?1716844024", naruto.getImage().getOriginal());
        assertEquals("/system/characters/preview/17.jpg?1716844024", naruto.getImage().getPreview());
        assertEquals("/system/characters/x96/17.jpg?1716844024", naruto.getImage().getX96());
        assertEquals("/system/characters/x48/17.jpg?1716844024", naruto.getImage().getX48());
        assertEquals("/characters/z17-naruto-uzumaki", naruto.getUrl());
        assertNull(naruto.getAltname());
        assertNull(naruto.getJapanese());
        assertNull(naruto.getDescription());
        assertNull(naruto.getDescriptionHtml());
        assertNull(naruto.getDescriptionSource());
        assertNull(naruto.getFavoured());
        assertNull(naruto.getThreadId());
        assertNull(naruto.getTopicId());
        assertNull(naruto.getUpdatedAt());
    }

}