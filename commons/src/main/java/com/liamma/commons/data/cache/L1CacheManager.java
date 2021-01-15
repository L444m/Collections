package com.liamma.commons.data.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/15 14:43
 * DESCRIPTION: L1 cache.
 */
public class L1CacheManager {

    private static volatile L1CacheManager instance = null;
    private Map<String, Object> memoryCache;

    private L1CacheManager() {
        if (memoryCache == null) {
            memoryCache = new HashMap<>();
        } else {
            // clear previous stored data.
            memoryCache.clear();
        }
    }

    public static L1CacheManager getInstance() {
        if (instance == null) {
            synchronized (L1CacheManager.class) {
                if (instance == null) {
                    instance = new L1CacheManager();
                }
            }
        }
        return instance;
    }

    public void put(@NonNull String key, @Nullable Object value) {
        memoryCache.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(@NonNull String key, T defaultValue) {
        Object o = memoryCache.get(key);
        if (o != null) {
            try {
                return (T) o;
            } catch (Exception e) {
                // swallow
                return defaultValue;
            }
        }
        return defaultValue;
    }

}
