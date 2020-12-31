package com.liamma.commons.utils;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2017/12/6 00:05
 * DESCRIPTION: Indicates whether the specified "Collection" is empty or not.
 */
public final class EmptyUtils {

    // Empty string.
    public static final String EMPTY_STRING = "";

    // Empty map, list, set, use Collections class to retrieve an empty instance.
    @SuppressWarnings("rawtypes")
    public static final Map EMPTY_MAP = Collections.EMPTY_MAP;
    @SuppressWarnings("rawtypes")
    public static final List EMPTY_LIST = Collections.EMPTY_LIST;
    @SuppressWarnings("rawtypes")
    public static final Set EMPTY_SET = Collections.EMPTY_SET;

    private EmptyUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    /**
     * Indicates whether the CharSequence is empty or not.
     *
     * @param sequence CharSequence
     * @return {@code true} if the specified sequence is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(CharSequence sequence) {
        return sequence == null || sequence.length() == 0;
    }

    /**
     * Indicates whether the CharSequence is not empty.
     *
     * @param sequence CharSequence
     * @return {@code true} if the specified sequence is not null or empty, otherwise {@code false}.
     */
    public static boolean isNotEmpty(CharSequence sequence) {
        return sequence != null && sequence.length() != 0;
    }

    /**
     * Indicates whether the Collection is empty or not.
     *
     * @param collection Collection, for {@link List} or {@link Set}.
     * @return {@code true} if the specified Collection is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    /**
     * Indicates whether the Map is empty or not.
     *
     * @param map Map
     * @return {@code true} if the specified map is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    /**
     * Indicates whether the Object array is empty or not.
     *
     * @param array Array
     * @param <T>   Type parameter
     * @return {@code true} if the specified array is null or empty, otherwise {@code false}.
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean isNotEmpty(T[] array) {
        return array != null && array.length != 0;
    }

    /**
     * Indicates whether the {@code boolean} array is empty or not.
     *
     * @param array Array
     * @return {@code true} if the specified boolean array is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(boolean[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(byte[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(char[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(int[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(short[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(long[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(float[] array) {
        return array != null && array.length != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(double[] array) {
        return array != null && array.length != 0;
    }

    /**
     * Indicates whether the SparseArray is empty or not.
     *
     * @param array SparseArray
     * @return {@code true} if the specified SparseArray is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(SparseArray<?> array) {
        return array == null || array.size() == 0;
    }

    /**
     * Indicates whether the SparseArray is not empty.
     *
     * @param array SparseArray
     * @return {@code true} if the specified SparseArray is not null or empty, otherwise {@code false}.
     */
    public static boolean isNotEmpty(SparseArray<?> array) {
        return array != null && array.size() != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(SparseIntArray array) {
        return array == null || array.size() == 0;
    }

    /**
     * @see EmptyUtils#isNotEmpty(SparseArray)
     */
    public static boolean isNotEmpty(SparseIntArray array) {
        return array != null && array.size() != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(SparseLongArray array) {
        return array == null || array.size() == 0;
    }

    /**
     * @see EmptyUtils#isNotEmpty(SparseArray)
     */
    public static boolean isNotEmpty(SparseLongArray array) {
        return array != null && array.size() != 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(SparseBooleanArray array) {
        return array == null || array.size() == 0;
    }

    /**
     * @see EmptyUtils#isNotEmpty(SparseArray)
     */
    public static boolean isNotEmpty(SparseBooleanArray array) {
        return array != null && array.size() != 0;
    }

}
