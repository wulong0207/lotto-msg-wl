package com.hhly.lottomsg.common.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;



/**
 * 加密工具类
 * @author zhanglei
 *
 */
public class EncryptUtil {
	
	/**
	 * PBKDF2
	 */
	private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";  
	  
    /** 
     * 盐的长度 
     */  
	private static final int SALT_BYTE_SIZE = 32 / 2;  
  
    /** 
     * 生成密文的长度 
     */  
    private static final int HASH_BIT_SIZE = 128 * 4;  
  
    /** 
     * 迭代次数 
     */  
    private static final int PBKDF2_ITERATIONS = 50;  
    
    /**
     * 默认盐值，创建初始密码用
     */
    private static final String DEFAULT_SALT="2f1e131cc3009026cf8991da3fd4ac38";
    
    /**
     * 默认初始密码
     */
    private static final String DEFAULT_PASSWORD = "123456";
  
    /** 
     * 对输入的密码进行验证 
     *  
     * @param attemptedPassword 待验证的密码 
     * @param encryptedPassword  密文 
     * @param salt  盐值 
     * @return 是否验证成功 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     */  
    private static boolean authenticate(String attemptedPassword, String encryptedPassword, String salt)  
            throws NoSuchAlgorithmException, InvalidKeySpecException {  
        // 用相同的盐值对用户输入的密码进行加密  
        String encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);  
        // 把加密后的密文和原密文进行比较，相同则验证成功，否则失败  
        return encryptedAttemptedPassword.equals(encryptedPassword);  
    }  
  
    /** 
     * 生成密文 
     *  
     * @param password 明文密码 
     * @param salt  盐值 
     * @return 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     */  
    private static String getEncryptedPassword(String password, String salt) throws NoSuchAlgorithmException,  
            InvalidKeySpecException {  
  
        KeySpec spec = new PBEKeySpec(password.toCharArray(), fromHex(salt), PBKDF2_ITERATIONS, HASH_BIT_SIZE);  
        SecretKeyFactory f = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);  
        return toHex(f.generateSecret(spec).getEncoded());  
    }  
  
    /** 
     * 通过提供加密的强随机数生成器 生成盐 
     *  
     * @return 
     * @throws NoSuchAlgorithmException 
     */  
    private static String generateSalt() throws NoSuchAlgorithmException {  
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");  
        byte[] salt = new byte[SALT_BYTE_SIZE];  
        random.nextBytes(salt);  
        return toHex(salt);  
    }  
  
    /** 
     * 十六进制字符串转二进制字符串 
     *  
     * @param   hex         the hex string 
     * @return              the hex string decoded into a byte array       
     */  
    private static byte[] fromHex(String hex) {  
        byte[] binary = new byte[hex.length() / 2];  
        for (int i = 0; i < binary.length; i++) {  
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);  
        }  
        return binary;  
    }  
  
    /** 
     * 二进制字符串转十六进制字符串 
     *  
     * @param   array       the byte array to convert 
     * @return              a length*2 character string encoding the byte array       
     */  
    private static String toHex(byte[] array) {  
        BigInteger bi = new BigInteger(1, array);  
        String hex = bi.toString(16);  
        int paddingLength = (array.length * 2) - hex.length();  
        if (paddingLength > 0)  
            return String.format("%0" + paddingLength + "d", 0) + hex;  
        else  
            return hex;  
    }      
    /**
     * 得到盐值
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getSalt() throws NoSuchAlgorithmException{
    	return generateSalt(); 
    }
    /**
     * 加密
     * @param password 加密前的密码
     * @param rCode 盐值
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String encrypt(String password,String rCode) throws NoSuchAlgorithmException, InvalidKeySpecException{
    	return getEncryptedPassword(password,rCode);
    }
    /**
     * 验证密码
     * @param password 
     * @param ciphertext 
     * @param rCode
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static boolean verify(String password,String ciphertext,String rCode) throws NoSuchAlgorithmException, InvalidKeySpecException {
    	return authenticate(password, ciphertext, rCode); 
    }
    
	 
	 /**
	  * 生成6位随机数字（以字符串形式）
	  * @return
	 * @throws NoSuchAlgorithmException 
	  */
	 public static String randomCode(){
		 return getRandomString(6);
	 }
	 
	 
	 /**
	 * 随机生成字符串,指定长度
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number =random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 随机生成字符串,指定长度
	 * @param length
	 * @return
	 */
	public static String getRandomLowerString(int length){
		String str="abcdefghijklmnopqrstuvwxyz0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number =random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 随机生成字符串,指定长度
	 * @param length
	 * @return
	 */
	public static String getRandomUpperString(int length){
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number =random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 生成6位随机数字 短信验证码
	 * @return
	 */
	public static String getRandomCode6() {
		Integer random = (int)((Math.random()*9+1)*100000);
		return random.toString();
	}
	
	/**
	 * 生成4位随机数字
	 * @return
	 */
	public static String getRandomCode4() {
		Integer random = (int)((Math.random()*9+1)*1000);
		return random.toString();
	}
	
	/**
	 * 创建默认密码
	 * @param rcode
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 */
	public static String createDefaultPassword(String rcode) {
		try {
			KeySpec spec = new PBEKeySpec(DEFAULT_PASSWORD.toCharArray(), DEFAULT_SALT.getBytes(), PBKDF2_ITERATIONS, HASH_BIT_SIZE);
			SecretKeyFactory f = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
			String password = toHex(f.generateSecret(spec).getEncoded());
			password = encrypt(password, rcode);
			return password;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		String rcode = getSalt();
		System.out.println(rcode);
	}
}

