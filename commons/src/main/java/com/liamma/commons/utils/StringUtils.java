package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2017/12/6 10:59
 * DESCRIPTION: Utility methods for String.
 * Most methods are suitable for {@link CharSequence}, which can be used {@link android.text.Editable} /
 * {@link android.text.Spannable} / {@link StringBuilder} / {@link StringBuffer} and so on.
 */
public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Indicates whether the {@link CharSequence} is empty or not.
     *
     * @param sequence CharSequence
     * @return {@code true} if the specified CharSequence is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(@Nullable CharSequence sequence) {
        return sequence == null || sequence.length() == 0;
    }

    /**
     * Indicates whether the {@link CharSequence} is <bold>not</> empty.
     *
     * @param sequence CharSequence
     * @return {@code true} if the specified CharSequence is not null or empty, otherwise {@code false}.
     */
    public static boolean isNotEmpty(@Nullable CharSequence sequence) {
        return sequence != null && sequence.length() != 0;
    }

    /**
     * Indicates whether the {@link CharSequence} is blank or not.
     */
    public static boolean isBlank(@Nullable CharSequence sequence) {
        return sequence == null || sequence.toString().trim().length() == 0;
    }

    /**
     * Indicates whether the {@link CharSequence} is <bold>not</> blank.
     */
    public static boolean isNotBlank(@Nullable CharSequence sequence) {
        return sequence != null && sequence.toString().trim().length() != 0;
    }

    /**
     * Returns an empty string if it's null.
     */
    @NonNull
    public static String nullToEmpty(@Nullable CharSequence sequence) {
        return sequence == null ? "" : sequence.toString();
    }

    /**
     * Returns the length of a {@link CharSequence} instance safely even though it's null.
     */
    public static int length(@Nullable CharSequence sequence) {
        return sequence == null ? 0 : sequence.length();
    }

    /**
     * Indicates whether the content of two {@link CharSequence} object is equal or not.
     */
    public static boolean equals(@Nullable CharSequence a, @Nullable CharSequence b) {
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
    @Nullable
    public static String reverse(@Nullable String s) {
        if (isBlank(s)) {
            return s;
        }

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
     * Returns a string with the first letter in upper case.
     */
    @Nullable
    public static String upperFirstLetter(@Nullable String s) {
        if (isBlank(s) || Character.isUpperCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * Returns a string with the first letter in lower case.
     */
    @Nullable
    public static String lowerFirstLetter(@Nullable String s) {
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
    @Nullable
    public static String removeAllSpecialChars(@Nullable String s) {
        if (isBlank(s)) {
            return s;
        }
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("");
    }

}
