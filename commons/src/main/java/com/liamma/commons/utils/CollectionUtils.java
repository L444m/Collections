package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2020/12/30 10:54
 * DESCRIPTION:
 */
public final class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    /**
     * Converts elements array to List.
     */
    @NonNull
    public static <T> List<T> toList(@Nullable T... array) {
        List<T> list = new ArrayList<>();
        if (EmptyUtils.isEmpty(array)) {
            return list;
        }
        Collections.addAll(list, array);
        return list;
    }

    @NonNull
    public static <T> T[] toArray(@Nullable T... array) {
        return array;
    }

    public static <K, V> Map<K, V> toMap(K[] keys, V[] values) {
        return null;
    }

    public static <T> Set<T> toSet(@Nullable T... array) {
        return null;
    }

    public static <T> void remove(@Nullable Collection<T> collection, @Nullable T... items) {
        if (EmptyUtils.isEmpty(collection) || EmptyUtils.isEmpty(items)) {
            return;
        }
    }

    /**
     * Splits a string value into a string list.
     */
    @NonNull
    public static List<String> stringToList(@Nullable String s, @Nullable String separator) {
        return new ArrayList<>(Arrays.asList(stringToArray(s, separator)));
    }

    /**
     * Splits a String value into a string array.
     */
    @NonNull
    public static String[] stringToArray(@Nullable String s, @Nullable String separator) {
        if (StringUtils.isEmpty(s)) {
            return new String[0];
        }
        if (separator == null) {
            separator = "";
        }
        return s.split(separator);
    }

    public static String arrayToString(@Nullable String[] array, @Nullable String separator) {
        if (EmptyUtils.isEmpty(array)) {
            return EmptyUtils.EMPTY_STRING;
        }
        boolean appendSeparator = separator != null;
        StringBuilder sb = new StringBuilder();

        return null;
    }

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
