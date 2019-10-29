package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;


/**
 * Url Utils.
 * Created by Liam on 2018/7/17.
 */
public final class UrlUtils {

    private UrlUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Appends parameters to a base Url.
     *
     * @param baseUrl Base Url
     * @param params  Parameters
     */
    public static String appendParams(@NonNull String baseUrl, @Nullable Map<String, ?> params) {

        if (EmptyUtils.isEmpty(params)) return baseUrl;

        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl);
        sb.append("?");
        for (String key : params.keySet()) {
            sb.append(key);
            sb.append("=");
            sb.append(String.valueOf(params.get(key)));
            sb.append("&");
        }

        String result = sb.toString();
        // del the last &.
        return result.substring(0, result.length() - 1);
    }

}
