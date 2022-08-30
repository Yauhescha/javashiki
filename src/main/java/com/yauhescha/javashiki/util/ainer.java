package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.UserImageApi;
import com.yauhescha.javashiki.model.reques.ImageResponse;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.io.File;

public class ainer {
    public static void main(String[] args) throws Exception {

        final UserImageApi imageApi = new AuthShikimori().getUserImageApi();

        File file = new File("C:\\Users\\yauhe\\Downloads\\1.jpg");

        final ImageResponse imageResponse = imageApi.postImage(file);

        System.out.println(imageResponse);

    }
}
