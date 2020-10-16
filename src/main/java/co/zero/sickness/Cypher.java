package co.zero.sickness;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Cypher {
    public static String key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static byte[] key_Array = Base64.getDecoder().decode(key);

    public static String encrypt(String strToEncrypt) {
        try {
            Cipher _Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            byte[] iv = {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 7, 7, 7, 7};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            Key SecretKey = new SecretKeySpec(key_Array, "AES");
            _Cipher.init(Cipher.ENCRYPT_MODE, SecretKey, ivspec);

            return Base64.getEncoder().encodeToString(_Cipher.doFinal(strToEncrypt.getBytes()));
        } catch (Exception e) {
            System.out.println("[Exception]:" + e.getMessage());
        }

        return null;
    }

    public static String decrypt(String EncryptedMessage) {
        try {
            Cipher _Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            byte[] iv = {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 7, 7, 7, 7};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            Key SecretKey = new SecretKeySpec(key_Array, "AES");
            _Cipher.init(Cipher.DECRYPT_MODE, SecretKey, ivspec);

            byte DecodedMessage[] = Base64.getDecoder().decode(EncryptedMessage);
            return new String(_Cipher.doFinal(DecodedMessage));

        } catch (Exception e) {
            System.out.println("[Exception]:" + e.getMessage());

        }
        return null;
    }

    public static void main(String[] args) {
        String data = "1234567890";
        String encrypted = encrypt(data);
        System.out.println(":::: ENCRYPTED = " + encrypted);
        System.out.println(":::: DECRYPTED = " + decrypt(encrypted));
    }
}