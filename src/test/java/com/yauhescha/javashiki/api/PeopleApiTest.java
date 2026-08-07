package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.People;
import com.yauhescha.javashiki.model.domen.PeopleFull;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PeopleApiTest extends CommonTestData {

    @Test
    public void findById() {
        Optional<PeopleFull> people = peopleApi.findById(1);
        assertNotNull(people);
        if (people.isPresent()) {
            assertNotNull(people.get().getName());
        }
    }

    @Test
    public void search() {
        List<People> people = peopleApi.search("Kana Hanazawa");
        assertNotNull(people);
    }

    @Test
    public void searchWithNull() {
        List<People> people = peopleApi.search(null);
        assertNotNull(people);
    }
}
