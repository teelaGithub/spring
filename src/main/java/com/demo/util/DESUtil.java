package com.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;

/**
 * DES对称加密，加密后可还原成原值
 *
 * @author litinglan 2019/4/18 15:38
 */
public class DESUtil {
    private static Key key;
    //指定DES加密解密所用密钥
    private static String KEY_STR = "myKey";

    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(new SecureRandom(KEY_STR.getBytes()));
            key = keyGenerator.generateKey();
            keyGenerator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //加密，返回BASE64编码的加密字符串
    public static String encoder(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            byte[] bytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return encoder.encode(doFinal);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //对BASE64编码的加密字符串进行解密
    public static String decoder(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if (args == null || args.length <= 0) {
            System.out.println("请输入字符串：");
        } else {
            for (String arg : args) {
                System.out.println(encoder(arg));
            }
        }
    }
}
