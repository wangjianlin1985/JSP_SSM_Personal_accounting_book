// 
// 
// 

package com.taoxiuxia.util;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.util.Random;

public class PasswordUtil
{
    public static String geneMD5WithSalt(String password) {
        final Random r = new Random();
        final StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        final int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; ++i) {
                sb.append("0");
            }
        }
        final String salt = sb.toString();
        password = md5Hex(String.valueOf(password) + salt);
        final char[] cs = new char[48];
        for (int j = 0; j < 48; j += 3) {
            cs[j] = password.charAt(j / 3 * 2);
            cs[j + 1] = salt.charAt(j / 3);
            cs[j + 2] = password.charAt(j / 3 * 2 + 1);
        }
        return new String(cs);
    }
    
    public static boolean verifyPassword(final String password, final String md5) {
        final char[] cs1 = new char[32];
        final char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        final String salt = new String(cs2);
        return md5Hex(String.valueOf(password) + salt).equals(new String(cs1));
    }
    
    public static String md5Hex(final String src) {
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            final byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        }
        catch (Exception e) {
            return null;
        }
    }
}
