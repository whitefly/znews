package com.example.znews.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserUtil {

    public static int ANONYMOUS_ID = 4;
    public static int SYSTEM_ID = 2;

    static private final String imageFoler = "static/images/res";
    static private final List<String> imageUrls;
    static private final Random random;

    static {
        random = new Random();
        imageUrls = new ArrayList<>();
        ClassPathResource classPathResource = new ClassPathResource(imageFoler);
        try {
            File fold = classPathResource.getFile();
            File[] imagesFiles = fold.listFiles();
            //所有图片url
            if (imagesFiles != null) {
                for (File item : imagesFiles) {
                    if (item.isFile() && item.getName().endsWith(".jpg")) {
                        imageUrls.add(item.getName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomImageUrl() {
        int size = imageUrls.size();
        return imageUrls.get(random.nextInt(size));
    }

}
