package com.example.znews.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    static private String MD5(String pwd) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashInBytes = md.digest(pwd.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    static public String getSaltPassword(String password, String salt) {
        return MD5(password + salt);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(MD5("tanajiya.tar.gz"));
    }
}

