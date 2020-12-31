package com.liamma.commons.utils;

import androidx.annotation.Nullable;

import java.util.Collection;

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

    public static <T> void remove(@Nullable Collection<T> collection, @Nullable T... items) {
        if (EmptyUtils.isEmpty(collection) || EmptyUtils.isEmpty(items)) {
            return;
        }
    }

}
