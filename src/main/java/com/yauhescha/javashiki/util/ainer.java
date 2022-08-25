package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.CalendarApi;
import com.yauhescha.javashiki.model.domen.Calendar;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Arrays;
import java.util.List;

public class ainer {
    public static void main(String[] args) {
//        new AuthShikimori().

        final CalendarApi calendarApi = new AuthShikimori().getCalendarApi();
        final List<Calendar> list = calendarApi.getCalendars();
        final List<Calendar> list2 = calendarApi.getCalendars(false);


        System.out.println(Arrays.toString(list.toArray()));

    }
}
