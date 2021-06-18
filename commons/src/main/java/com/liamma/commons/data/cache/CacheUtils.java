package com.liamma.commons.data.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/15 16:04
 * DESCRIPTION:
 */
public final class CacheUtils {

    private CacheUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static <T extends Serializable> void putL1(@NonNull String key, @Nullable T value) {
        MemoryCacheManager.getInstance().put(key, CacheObject.newInstance(value, false, -1L));
    }

    public static <T extends Serializable> T getL1(@NonNull String key, T defaultValue) {
        return MemoryCacheManager.getInstance().get(key, defaultValue);
    }

    public static void putL2() {
    }

    public static void putL3() {
    }
}
