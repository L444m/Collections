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

    public static <T> void putL1(@NonNull String key, @Nullable T value) {
        L1CacheManager.getInstance().put(key, CacheObject.newInstance(value, false, -1L));
    }

    public static <T> T getL1(@NonNull String key, T defaultValue) {
        return L1CacheManager.getInstance().get(key, defaultValue);
    }

    public static void putL2() {

    }

    public static void putL3() {

    }
}
