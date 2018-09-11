package com.hhly.lottomsg.config;

import org.jasypt.digest.PooledStringDigester;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Created by pengqq622 on 2018/4/20.
 */
public class DESEncryptUtil {

    private static final String PASSWORD_CRYPT_KEY = "@^_^123aBcZ*";
    private static final String ALGORITHM = "DES";

    public DESEncryptUtil() {
    }

    /*public static void main(String[] args) throws Exception {
        String md5Password = "oRcl_123";
        String str = encrypt(md5Password);
        System.out.println("str: " + str);
        str = decrypt(str);
        System.out.println("str: " + str);
    }*/

    public static final String decrypt(String data) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()), "@^_^123aBcZ*".getBytes()));
    }

    public static final String decrypt(String data, String key) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()), key.getBytes()));
    }

    public static final String encrypt(String data) throws Exception {
        return byte2hex(encrypt(data.getBytes(), "@^_^123aBcZ*".getBytes()));
    }

    public static final String encrypt(String data, String key) throws Exception {
        return byte2hex(encrypt(data.getBytes(), key.getBytes()));
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, securekey, sr);
        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, securekey, sr);
        return cipher.doFinal(data);
    }

    public static byte[] hex2byte(byte[] b) {
        if(b.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        } else {
            byte[] b2 = new byte[b.length / 2];

            for(int n = 0; n < b.length; n += 2) {
                String item = new String(b, n, 2);
                b2[n / 2] = (byte)Integer.parseInt(item, 16);
            }

            return b2;
        }
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if(stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }

   public static void main(String[] args){
        //加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
       EnvironmentStringPBEConfig  config = new EnvironmentStringPBEConfig ();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("@^_^123aBcZ*");
        //应用配置
        encryptor.setConfig(config);
        String plaintext="oRcl_123";
        //加密
      // String ciphertext = "Lhe+wroEO87CjL3JrUMHvDoE82S6SXjB";
        String ciphertext=encryptor.encrypt(plaintext);
      //String plaintext1 = encryptor.decrypt(ciphertext);
       System.out.println(plaintext + " : " + ciphertext);
      // System.out.println(ciphertext + " : " + plaintext1);
   }

    //Y2FNoILA9l6wUk92I0wRrlm36FuQpEzK
    //Lhe+wroEO87CjL3JrUMHvDoE82S6SXjB






}
