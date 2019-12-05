package com.july.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * md5密码加密
 * @author: zqk
 * @since: 2019/11/4
 */
public class Md5Util {

    /**
     * 生成含有随机盐的密码
     */
    public static String generatePassword(String password, String salt) {
        return md5Hex(salt+password );
    }
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

}
