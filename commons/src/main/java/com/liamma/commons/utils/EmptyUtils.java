package com.liamma.commons.utils;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;

import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Indicates whether the specified "Collection" is empty or not.
 * Created by Liam on 2017/12/6.
 */
public final class EmptyUtils {

    // Empty string.
    public static final String EMPTY_STRING = "";

    // Empty map, list, set, use Collections class to retrieve an empty instance.
    public static final Map EMPTY_MAP = Collections.EMPTY_MAP;
    public static final List EMPTY_LIST = Collections.EMPTY_LIST;
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
    public static boolean isEmpty(@Nullable CharSequence sequence) {
        return sequence == null || sequence.length() == 0;
    }

    /**
     * Indicates whether the Collection is empty or not.
     *
     * @param collection Collection, for {@link List} or {@link Set}.
     * @return {@code true} if the specified Collection is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(@Nullable Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Indicates whether the Map is empty or not.
     *
     * @param map Map
     * @return {@code true} if the specified map is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(@Nullable Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * Indicates whether the Object array is empty or not.
     *
     * @param array Array
     * @param <T>   Type parameter
     * @return {@code true} if the specified array is null or empty, otherwise {@code false}.
     */
    public static <T> boolean isEmpty(@Nullable T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Indicates whether the {@code boolean} array is empty or not.
     *
     * @param array Array
     * @return {@code true} if the specified boolean array is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(@Nullable boolean[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(@Nullable double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Indicates whether the SparseArray is empty or not.
     *
     * @param array SparseArray
     * @return {@code true} if the specified SparseArray is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(@Nullable SparseArray array) {
        return array == null || array.size() == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(@Nullable SparseIntArray array) {
        return array == null || array.size() == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(@Nullable SparseLongArray array) {
        return array == null || array.size() == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(@Nullable SparseBooleanArray array) {
        return array == null || array.size() == 0;
    }

}
