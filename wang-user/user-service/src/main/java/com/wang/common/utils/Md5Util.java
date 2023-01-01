package com.wang.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author wang
 * @version 1.0.0
 * @description TODO
 * @date 2022/12/28 19:15
 */
public class Md5Util {

    private static final String salt = "1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String pswToUser(String rawPassword){
        return md5(salt.charAt(0)+salt.charAt(2) + rawPassword +salt.charAt(5) + salt.charAt(4));
    }


}
