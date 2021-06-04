package com.liamma.commons.data.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/15 14:43
 * DESCRIPTION: Cache objects or data in Memory, it is the first level cache in cache system.
 */
public class MemoryCacheManager {

    private static volatile MemoryCacheManager instance = null;
    private Map<String, CacheObject<?>> memoryCache;

    private MemoryCacheManager() {
        if (memoryCache == null) {
            memoryCache = new HashMap<>();
        } else {
            // clear previous stored data.
            memoryCache.clear();
        }
    }

    public static MemoryCacheManager getInstance() {
        if (instance == null) {
            synchronized (MemoryCacheManager.class) {
                if (instance == null) {
                    instance = new MemoryCacheManager();
                }
            }
        }
        return instance;
    }

    public void put(@NonNull String key, @Nullable CacheObject<?> value) {
        memoryCache.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(@NonNull String key, @NonNull T defaultValue) {
        CacheObject<?> cacheObject = memoryCache.get(key);
        if (cacheObject != null) {
            try {
                return (T) cacheObject;
            } catch (Exception e) {
                // swallow
                return defaultValue;
            }
        }
        return defaultValue;
    }

}
