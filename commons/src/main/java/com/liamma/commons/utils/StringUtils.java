package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Utility methods for String.
 * Created by Liam on 2017/12/6.
 */
public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Indicates whether the String is empty.
     *
     * @param s String
     * @return {@code true} if the specified string is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /**
     * Indicates whether the String is not empty.
     *
     * @param s String
     * @return {@code true} if the specified string is not null and not empty, otherwise {@code false}.
     */
    public static boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }

    /**
     * Indicates whether the string is blank.
     *
     * @param s String
     * @return {@code true} if the specified string is null or blank, otherwise {@code false}.
     */
    public static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * Returns an empty string if it's null.
     */
    public static String nullToEmpty(String s) {
        return s == null ? "" : s;
    }

    /**
     * Returns the length of an string safely even though it's null.
     */
    public static int length(String s) {
        return s == null ? 0 : s.length();
    }

    /**
     * Indicates whether the two strings is equal.
     *
     * @param a CharSequence
     * @param b CharSequence
     * @return {@code true} if two CharSequences are equals, otherwise {@code false}.
     */
    public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the reversed string.
     */
    public static String reverse(String s) {
        if (isBlank(s)) return s;

        int len = s.length();
        int mid = len >> 1;
        char[] chars = s.toCharArray();
        char c;

        for (int i = 0; i < mid; i++) {
            c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }

    /**
     * Returns this string with the first letter in upper case.
     */
    public static String upperFirstLetter(String s) {
        if (isEmpty(s) || Character.isUpperCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * Returns this string with the first letter in lower case.
     */
    public static String lowerFirstLetter(String s) {
        if (isEmpty(s) || Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
    }

    /**
     * Removes all special characters in the specified string.
     *
     * @param s String
     * @return a string with all special characters removed
     */
    public static String removeAllSpecialChars(@NonNull String s) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("");
    }

    /**
     * Splits a string into string list.
     *
     * @param s         String
     * @param separator String
     */
    public static List<String> stringToList(@Nullable String s, @NonNull String separator) {
        if (isEmpty(s)) {
            return new ArrayList<>();
        }
        String[] strings = s.split(separator);
        return new ArrayList<>(Arrays.asList(strings));
    }

    /**
     * Converts a string list to string.
     *
     * @param list      {@code List<String>}
     * @param separator String
     */
    public static String listToString(@Nullable List<String> list, @Nullable String separator) {
        if (EmptyUtils.isEmpty(list)) {
            return EmptyUtils.EMPTY_STRING;
        }

        boolean appendSeparator = separator != null;
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
            if (appendSeparator) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

}
