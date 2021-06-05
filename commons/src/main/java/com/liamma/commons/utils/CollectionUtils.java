package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Returns the size of the given collection, or 0 if null.
     */
    public static int size(@Nullable Collection<?> collection) {
        return collection == null ? 0 : collection.size();
    }

    /**
     * Returns the size of the given map, or 0 if null.
     */
    public static int size(@Nullable Map<?, ?> map) {
        return map == null ? 0 : map.size();
    }

    /**
     * Returns an empty mutable list if the specified list is null.
     *
     * @return an empty {@code ArrayList} instance
     */
    @NonNull
    public static <T> List<T> nullToEmpty(@Nullable List<T> list) {
        return list == null ? new ArrayList<>() /*Collections.emptyList()*/ : list;
    }

    /**
     * Returns an empty mutable set if the specified set is null.
     *
     * @return an empty {@code HashSet} instance
     */
    @NonNull
    public static <T> Set<T> nullToEmpty(@Nullable Set<T> set) {
        return set == null ? new HashSet<>() /*Collections.emptySet()*/ : set;
    }

    /**
     * Returns an empty mutable map if the specified map is null.
     *
     * @return an empty {@code HashMap} instance
     */
    @NonNull
    public static <K, V> Map<K, V> nullToEmpty(@Nullable Map<K, V> map) {
        return map == null ? new HashMap<>() /*Collections.emptyMap()*/ : map;
    }

    /**
     * Converts an element array to a {@code ArrayList}.
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

    /**
     * Converts a element array to a {@code HashSet}.
     */
    @NonNull
    public static <T> Set<T> toSet(@Nullable T... array) {
        Set<T> set = new HashSet<>();
        if (EmptyUtils.isEmpty(array)) {
            return set;
        }
        Collections.addAll(set, array);
        return set;
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

    /**
     * Converts a String array into a String.
     */
    @NonNull
    public static String arrayToString(@Nullable String[] array, @Nullable String separator) {
        if (EmptyUtils.isEmpty(array)) {
            return EmptyUtils.EMPTY_STRING;
        }

        boolean appendSeparator = separator != null;
        StringBuilder sb = new StringBuilder();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
            if (appendSeparator && i != (length - 1)) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * Converts a String list into a String.
     */
    @NonNull
    public static String listToString(@Nullable List<String> list, @Nullable String separator) {
        if (EmptyUtils.isEmpty(list)) {
            return EmptyUtils.EMPTY_STRING;
        }

        boolean appendSeparator = separator != null;
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (appendSeparator && i != (size - 1)) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    @NonNull
    public static <T> List<T> intersection(@Nullable Collection<T> c1, @Nullable Collection<T> c2) {
        List<T> result = new ArrayList<>();
        if (EmptyUtils.isEmpty(c1) || EmptyUtils.isEmpty(c2)) {
            return result;
        }

        return result;
    }

    public static <T> List<T> union(@Nullable Collection<T> c1, @Nullable Collection<T> c2) {
        List<T> result = new ArrayList<>();
        if (EmptyUtils.isEmpty(c1) && EmptyUtils.isEmpty(c2)) {
            return result;
        }
        if (EmptyUtils.isEmpty(c1)) {
            result.addAll(c2);
            return result;
        }
        if (EmptyUtils.isEmpty(c2)) {
            result.addAll(c1);
            return result;
        }
        return result;
    }

}
