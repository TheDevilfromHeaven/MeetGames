package com.ljh.MeetGames.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public final class Md5 {

    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private Md5() {
        throw new AssertionError("No xu.binary.util.encrypt.Md5 instance for you!");
    }

    public static String encrypt(String password) {
        Objects.requireNonNull(password);
//		md5加密 随机盐 12位byte数组
        byte[] salt = new byte[12];
//		获取密码的byte数组
        byte[] bytes = password.getBytes();
//		随机盐
        new SecureRandom().nextBytes(salt);

        messageDigest.update(salt);// 将盐拿去加密
        messageDigest.update(bytes);// 将密码拿去加密
        byte[] digest = messageDigest.digest();// 得到md5算法加密的byte数组

        byte[] encryptBytes = new byte[12 + digest.length];

        System.arraycopy(salt, 0, encryptBytes, 0, 12);
        System.arraycopy(digest, 0, encryptBytes, 12, digest.length);

        return Base64.getEncoder().encodeToString(encryptBytes);

    }

    public static boolean validate(String password, String encrypt) {
//		非空检查
        Objects.requireNonNull(password);
        Objects.requireNonNull(encrypt);

//		将加密字符串转成byte数组
        byte[] decode = Base64.getDecoder().decode(encrypt);
//		取出前12位随机盐
        byte[] salt = Arrays.copyOf(decode, 12);
//		取出后部分md5加密
        byte[] encryptBytes = Arrays.copyOfRange(decode, 12, decode.length);
//		加密随机盐
        messageDigest.update(salt);
//		加密密码
        messageDigest.update(password.getBytes());
//		得到md5加密密码
        byte[] digest = messageDigest.digest();
//		比较当次加密和前次加密
        return Arrays.equals(encryptBytes, digest);

    }

}