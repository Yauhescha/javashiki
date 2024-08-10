package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Calendar;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CALENDAR_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class CalendarApi {
    private static final String SEARCH_PARAMETER = "censored";
    
    private final AuthShikimori auth;

    public List<Calendar> getCalendars() {
        Calendar[] calendars = new ApiRequest<>(auth, Calendar[].class)
                .execute(GET, METHOD_CALENDAR_GET);
        if (calendars == null) {
            return List.of();
        }
        return Arrays.asList(calendars);
    }

    public List<Calendar> getCalendars(boolean censored) {
        Calendar[] calendars = new ApiRequest<>(auth, Calendar[].class)
                .execute(GET, METHOD_CALENDAR_GET, Map.of(SEARCH_PARAMETER, censored));
        if (calendars == null) {
            return List.of();
        }
        return Arrays.asList(calendars);
    }
}
