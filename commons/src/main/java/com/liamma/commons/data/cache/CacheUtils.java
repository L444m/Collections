package com.liamma.commons.data.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/15 16:04
 * DESCRIPTION:
 */
public final class CacheUtils {

    private CacheUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    public static void putL1(@NonNull String key, @Nullable Object value) {
        L1CacheManager.getInstance().put(key, value);
    }

    public static <T> T getL1(@NonNull String key, T defaultValue) {
        return L1CacheManager.getInstance().get(key, defaultValue);
    }

    public static void putL2() {

    }

    public static void putL3() {

    }
}
