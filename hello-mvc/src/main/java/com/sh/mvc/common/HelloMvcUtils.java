package com.sh.mvc.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HelloMvcUtils {
    /**
     * <pre>
     * 암호화
     * 1. MessageDigest (암호화)
     *  - 암호화 방식
     *      - 단방향 알고리즘(sha512)
     *      - salt값을 사용해서 보안성 높이기
     *      - 양방향
     * 2. Encoding (이진데이터 텍스트 변환 과정)
     */
    public static String getEncryptedPassword(String password, String salt) {
        String encryptedPassword = null;
        // 1. 암호화 (hashing)
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] input = password.getBytes("utf-8");
            byte[] saltinput = salt.getBytes("utf-8");
            md.update(saltinput);
            byte[] output = md.digest(input); // 이진데이터

            // 2. 인코딩 (64개 문자 - 영대소문자(52), 숫자(10), +, /) + padding(=)
            Base64.Encoder encoder = Base64.getEncoder();
            encryptedPassword = encoder.encodeToString(output);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return encryptedPassword;
    }
}
