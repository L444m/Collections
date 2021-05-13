package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
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
        return null;
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

}
