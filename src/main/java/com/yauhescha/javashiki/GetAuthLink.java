package com.yauhescha.javashiki;

import com.yauhescha.javashiki.request.AuthShikimori;

public class GetAuthLink {
    public static void main(String[] args) {
        AuthShikimori auth = new AuthShikimori();
        String link = auth.getUrlToAuthorizationCode();
        System.out.println("Откройте эту ссылку в браузере:");
        System.out.println(link);
        System.out.println("\nПосле авторизации вы получите code. Сохраните его и используйте в AuthorizeToken.");
    }
}
