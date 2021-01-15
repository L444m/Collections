package com.liamma.commons.data.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/15 14:43
 * DESCRIPTION:
 */
public class L2CacheManager {

    private static volatile L2CacheManager instance = null;
    private Map<String, Object> memoryCache;

    private L2CacheManager() {
        if (memoryCache == null) {
            memoryCache = new HashMap<>();
        } else {
            // clear previous stored data.
            memoryCache.clear();
        }
    }

    public static L2CacheManager getInstance() {
        if (instance == null) {
            synchronized (L2CacheManager.class) {
                if (instance == null) {
                    instance = new L2CacheManager();
                }
            }
        }
        return instance;
    }

}
