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
 * Indicates whether the specified "Collection" is empty or not.
 * Created by Liam on 2017/12/6.
 */
public final class EmptyUtils {

    // Empty string.
    public static final String EMPTY_STRING = "";

    // Use Collections class to retrieve an empty "collection" instance.
    public static final Map EMPTY_MAP = Collections.EMPTY_MAP;
    public static final List EMPTY_LIST = Collections.EMPTY_LIST;
    public static final Set EMPTY_SET = Collections.EMPTY_SET;

    private EmptyUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
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
     * Indicates whether the Collection is empty or not.
     *
     * @param collection Collection, for {@link List} or {@link Set}.
     * @return {@code true} if the specified Collection is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Indicates whether the Map is empty or not.
     *
     * @param map Map
     * @return @return {@code true} if the specified map is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
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

    /**
     * Indicates whether the {@code boolean} array is empty or not.
     *
     * @param array Array
     * @return {@code true} if the specified boolean array is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(boolean[])
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Indicates whether the SparseArray is empty or not.
     *
     * @param sparseArray SparseArray
     * @return {@code true} if the specified SparseArray is null or empty, otherwise {@code false}.
     */
    public static boolean isEmpty(SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(SparseIntArray sparseIntArray) {
        return sparseIntArray == null || sparseIntArray.size() == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray == null || sparseLongArray.size() == 0;
    }

    /**
     * @see EmptyUtils#isEmpty(SparseArray)
     */
    public static boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray == null || sparseBooleanArray.size() == 0;
    }

}
