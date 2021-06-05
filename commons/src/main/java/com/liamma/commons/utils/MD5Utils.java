package com.liamma.commons.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2017/12/11 16:11
 * DESCRIPTION: MD5 utils. Converts an arbitrary number of bytes into a fixed-length (32bits) byte
 * sequence.
 */
public final class MD5Utils {

    private MD5Utils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Returns MD5 digest of the specified byte array.
     *
     * @return string value which is a concatenation of characters from '0' to
     * '9' and 'a' to 'f'.
     */
    public static String md5(byte[] bytes) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] encode = digest.digest(bytes);

            // Converts encoded byte array to HEX string.
            StringBuilder sb = new StringBuilder();
            String hex;

            for (byte b : encode) {
                hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    sb.append(0);
                }
                sb.append(hex);
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5(String s) {
        return md5(s.getBytes());
    }

    /**
     * Returns MD5 digest with upper-case hex coding of a byte array.
     */
    public static String md5ToUpperHex(byte[] bytes) {
        char[] upperHexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] encode = digest.digest(bytes);

            StringBuilder sb = new StringBuilder();
            for (byte b : encode) {
                int high = ((b & 0xf0) >> 4);
                int low = (b & 0x0f);
                sb.append(upperHexChars[high]);
                sb.append(upperHexChars[low]);
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5ToUpperHex(String s) {
        return md5ToUpperHex(s.getBytes());
    }

}
