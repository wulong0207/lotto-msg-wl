/**
 * Copyright(c) 2016 ShenZhen Gowild Network Technology Co., Ltd. All rights reserved.
 * Created on  2016/10/14  18:40
 */
package com.hhly.lottomsg.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;


/**
 * 功能：MD5加密处理核心文件
 */

public class Md5EncryptSign {
    /**
     * Used building output as Hex
     */
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 对字符串进行MD5加密
     *
     * @param text 明文
     * @return 密文
     */
    public static String md5(String text, String charsetname) {
        MessageDigest msgDigest = null;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "System doesn't support MD5 algorithm.");
        }

        try {
            msgDigest.update(text.getBytes(charsetname));    //注意改接口是按照指定编码形式签名

        } catch (UnsupportedEncodingException e) {

            throw new IllegalStateException(
                    "System doesn't support your  EncodingException.");

        }

        byte[] bytes = msgDigest.digest();

        String md5Str = new String(encodeHex(bytes));

        return md5Str;
    }

    public static char[] encodeHex(byte[] data) {

        int l = data.length;

        char[] out = new char[l << 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }

        return out;
    }


    @SuppressWarnings("rawtypes")
	public static String createSign(String characterEncoding,SortedMap<String,Object> parameters, String appSecret){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("appSecret=" + appSecret);
        return md5(sb.toString(), characterEncoding);
    }
}