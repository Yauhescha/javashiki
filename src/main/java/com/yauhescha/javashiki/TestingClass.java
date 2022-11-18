package com.yauhescha.javashiki;

import com.yauhescha.javashiki.constant.MessageType;
import com.yauhescha.javashiki.model.domen.AnimeMangaRate;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.message.Message;
import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.model.reques.AnimeMangaRateParameters;
import com.yauhescha.javashiki.model.reques.UserMessageParameters;
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


        System.out.println("Message type: ");
        System.out.println(MessageType.INBOX);
        List<Message> list = auth.getUserApi().getMessages(325803, UserMessageParameters.builder().type(MessageType.INBOX).build());
        printList(list);
        System.out.println("");

        System.out.println("Message type: ");
        System.out.println(MessageType.NEWS);
        list = auth.getUserApi().getMessages(325803, UserMessageParameters.builder().type(MessageType.NEWS).build());
        printList(list);
        System.out.println("");

        System.out.println("Message type: ");
        System.out.println(MessageType.SENT);
        list = auth.getUserApi().getMessages(325803, UserMessageParameters.builder().type(MessageType.SENT).build());
        printList(list);
        System.out.println("");

        System.out.println("Message type: ");
        System.out.println(MessageType.NOTIFICATIONS);
        list = auth.getUserApi().getMessages(325803, UserMessageParameters.builder().type(MessageType.NOTIFICATIONS).build());
        printList(list);
        System.out.println("");


    }

    private static void printList(List list) {
        System.out.println("before printing");
        list.stream().forEach(System.out::println);
        System.out.println("afterPrinting");
    }
}
