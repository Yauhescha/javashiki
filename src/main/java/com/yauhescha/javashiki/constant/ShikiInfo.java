package com.yauhescha.javashiki.constant;

public class ShikiInfo {
    public static final String APPLICATION_NAME = "Javashiki";
    public static final String APPLICATION_CLIENT_ID = "yYGBEgPj6gCWio41cWPoKbTPL2bgFg2gVjBb-EQrUpc";
    public static final String APPLICATION_CLIENT_SECRET = "NiAm85gyH25wvtdljbBuDC1lkfnYSDOgshBxX-m8Kto";
    public static final String APPLICATION_REDIRECT_URI = "https://amiaprogrammist.herokuapp.com/shiki";

    public static final String URL_SHIKIMORI = "https://shikimori.one";
    public static final String URL_API_V1 = URL_SHIKIMORI + "/api";
    public static final String URL_API_V2 = URL_SHIKIMORI + "/api/v2";
    public static final String URL_AUTHORIZE = URL_SHIKIMORI + "/oauth/authorize";
    public static final String URL_TOKEN = URL_SHIKIMORI + "/oauth/token";

    public static final String PARAM_RESPONSE_TYPE = "response_type";
    public static final String PARAM_GRANT_TYPE = "grant_type";
    public static final String PARAM_CODE = "code";
    public static final String PARAM_REDIRECT_URI = "redirect_uri";
    public static final String PARAM_CLIENT_ID = "client_id";
    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String PARAM_REFRESH_TOKEN = "refresh_token";

    public static final String RESPONSE_TYPE_CODE = "code";
    public static final String REDIRECT_URI_DEFAULT = "https://amiaprogrammist.herokuapp.com/shiki";
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    public static final String METHOD_ANIMES_GET = "/animes";
    public static final String METHOD_ANIMES_GET_ID = METHOD_ANIMES_GET + "/%s";
    public static final String METHOD_ANIMES_ROLES = METHOD_ANIMES_GET_ID + "/roles";
    public static final String METHOD_ANIMES_SIMILAR = METHOD_ANIMES_GET_ID + "/similar";
    public static final String METHOD_ANIMES_RELATED = METHOD_ANIMES_GET_ID + "/related";
    public static final String METHOD_ANIMES_SCREENSHOTS = METHOD_ANIMES_GET_ID + "/screenshots";
    public static final String METHOD_ANIMES_FRANCHISE = METHOD_ANIMES_GET_ID + "/franchise";
    public static final String METHOD_ANIMES_EXTERNAL_LINKS = METHOD_ANIMES_GET_ID + "/external_links";
    public static final String METHOD_ANIMES_TOPICS = METHOD_ANIMES_GET_ID + "/topics";

    public static final String METHOD_APPEARS_POST = "/appears";

    public static final String METHOD_ACHIEVEMETS_GET = "/achievements";

    public static final String METHOD_BANS_GET = "/bans";

    public static final String METHOD_CALENDAR_GET = "/calendar";

    public static final String METHOD_FORUMS_GET = "/forums";

    public static final String METHOD_STUDIOS_GET = "/studios";

    public static final String METHOD_GENRES_GET = "/genres";

    public static final String METHOD_STATS_ACTIVE_USER_GET = "/stats/active_users";

    public static final String METHOD_PUBLISHERS_GET = "/publishers";

//    public static final String METHOD_MANGAS_GET = "mangas";
//    public static final String METHOD_MANGAS_GET_ID = METHOD_MANGAS_GET + "/%s";
//    public static final String METHOD_MANGAS_SIMILAR = METHOD_MANGAS_GET_ID + "/similar";
//    public static final String METHOD_MANGAS_ROLES = METHOD_MANGAS_GET_ID + "/roles";
//    public static final String METHOD_MANGAS_RELATED = METHOD_MANGAS_GET_ID + "/related";
//    public static final String METHOD_MANGAS_FRANCHISE = METHOD_MANGAS_GET_ID + "/franchise";
//    public static final String METHOD_MANGAS_EXTERNAL_LINKS = METHOD_MANGAS_GET_ID + "/external_links";
//
//    public static final String METHOD_USERS_GET = "users";
//    public static final String METHOD_USERS_GET_ID = METHOD_USERS_GET + "/%s";
//    public static final String METHOD_USERS_INFO = METHOD_USERS_GET_ID + "/info";
//    public static final String METHOD_USERS_WHOAMI = METHOD_USERS_GET + "/whoami";
//    public static final String METHOD_USERS_SIGN_OUT = METHOD_USERS_GET + "/sign_out";
//    public static final String METHOD_USERS_FRIENDS = METHOD_USERS_GET_ID + "/friends";
//    public static final String METHOD_USERS_CLUBS = METHOD_USERS_GET_ID + "/clubs";
//    public static final String METHOD_USERS_ANIME_RATES = METHOD_USERS_GET_ID + "/anime_rates";
//    public static final String METHOD_USERS_MANGA_RATES = METHOD_USERS_GET_ID + "/manga_rates";
//    public static final String METHOD_USERS_FAVOURITES = METHOD_USERS_GET_ID + "/favourites";
//    public static final String METHOD_USERS_MESSAGES = METHOD_USERS_GET_ID + "/messages";
//    public static final String METHOD_USERS_UNREAD_MESSAGES = METHOD_USERS_GET_ID + "/unread_messages";
//    public static final String METHOD_USERS_HISTORY = METHOD_USERS_GET_ID + "/history";
//    public static final String METHOD_USERS_BANS = METHOD_USERS_GET_ID + "/bans";
}
