package com.yauhescha.javashiki;

import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;
import java.util.Scanner;

public class TestingClass {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String applicationName = "Javashiki";
    public static final String applicationClientId = "yYGBEgPj6gCWio41cWPoKbTPL2bgFg2gVjBb-EQrUpc";
    public static final String applicationClientSecret = "NiAm85gyH25wvtdljbBuDC1lkfnYSDOgshBxX-m8Kto";
    public static final String applicationRedirectUri = "urn:ietf:wg:oauth:2.0:oob";
    public static void main(String[] args) {

//        AuthShikimori auth = new AuthShikimori(applicationName, applicationClientId, applicationClientSecret, applicationRedirectUri);
        AuthShikimori auth = new AuthShikimori();
        String linkToAuthorizationCode = auth.getUrlToAuthorizationCode();
        System.out.println(linkToAuthorizationCode);
        System.out.println();
        System.out.println("Input code: ");
        auth.authorize(scanner.nextLine());
        System.out.println();


        List<User> list = auth.getUserApi().getFriends(325803);
        printList(list);

    }

    private static void printList(List<User> list) {
        System.out.println("before printing");
        list.stream().forEach(System.out::println);
        System.out.println("afterPrinting");
    }
}
