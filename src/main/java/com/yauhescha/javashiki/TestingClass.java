package com.yauhescha.javashiki;

import com.yauhescha.javashiki.constant.MessageType;
import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeMangaRate;
import com.yauhescha.javashiki.model.domen.Genre;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.message.Message;
import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.model.reques.AnimeMangaRateParameters;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import com.yauhescha.javashiki.model.reques.UserMessageParameters;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;
import java.util.Scanner;

public class TestingClass {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String applicationName = "Javashiki";
    public static final String applicationRedirectUri = "urn:ietf:wg:oauth:2.0:oob";
    public static final String applicationClientId = "yYGBEgPj6gCWio41cWPoKbTPL2bgFg2gVjBb-EQrUpc";
    public static final String applicationClientSecret = "NiAm85gyH25wvtdljbBuDC1lkfnYSDOgshBxX-m8Kto";

    public static void main(String[] args) {

//        AuthShikimori auth = new AuthShikimori(TESTapplicationName, TESTapplicationClientId, TESTapplicationClientSecret, applicationRedirectUri);
        AuthShikimori auth = new AuthShikimori();
//        String linkToAuthorizationCode = auth.getUrlToAuthorizationCode();
//        System.out.println(linkToAuthorizationCode);
//        System.out.println();
//        System.out.println("Input code: ");
//        auth.authorize(scanner.nextLine());
//        System.out.println();

        System.out.println(auth.getUserApi().whoIAm());

        System.out.println("Message type: ");
        System.out.println(MessageType.INBOX);
        AnimeSearchParameters parameters = AnimeSearchParameters.builder().search("naruto").build();
        List<Anime> animes = auth.getAnimeApi().getAnimes(parameters);
        printList(animes);
        System.out.println();



    }

    private static void printList(List<?> list) {
        System.out.println("before printing");
        list.forEach(System.out::println);
        System.out.println("afterPrinting");
    }
}
