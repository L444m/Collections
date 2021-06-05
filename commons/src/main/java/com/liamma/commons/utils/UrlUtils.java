package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/17 16:36
 * DESCRIPTION: Url Utils.
 */
public final class UrlUtils {

    public static final String SCHEME_HTTP = "http://";
    public static final String SCHEME_HTTPS = "https://";

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

    public static Map<String, Object> getParams(String url) {
        return null;
    }

    public static String getBaseUrl(String url) {
        return null;
    }

    public static String getScheme(String url) {
        return null;
    }

    public static String getDomain(String url) {
        return null;
    }

    public static String getIpAddress(String url) {
        return null;
    }

    public static String getPort(String url) {
        return null;
    }

}
