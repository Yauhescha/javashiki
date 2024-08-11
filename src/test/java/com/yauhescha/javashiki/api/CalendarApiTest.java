package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Calendar;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalendarApiTest extends CommonTestData {

    @Test
    public void getCalendars() {
        List<Calendar> calendars = calendarApi.getCalendars();
        assertFalse(calendars.isEmpty());
        Calendar calendar = calendars.get(0);
        assertTrue(calendar.getNextEpisode() > 0);
        assertTrue(calendar.getAnime().getId() > 0);
    }

    @Test
    public void getCalendarsUncensored() {
        List<Calendar> calendars = calendarApi.getCalendars(false);
        assertFalse(calendars.isEmpty());
        Calendar calendar = calendars.get(0);
        assertTrue(calendar.getNextEpisode() > 0);
        assertTrue(calendar.getAnime().getId() > 0);
    }
}