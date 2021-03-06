package com.liamma.commons.http.okhttp.interceptor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.utils.EmptyUtils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/19 14:40
 * DESCRIPTION: Interceptor for adding headers in requests.
 */
public class HeaderInterceptor implements Interceptor {

    private final Map<String, Object> headers = new LinkedHashMap<>();

    public HeaderInterceptor() {
    }

    public HeaderInterceptor(@Nullable Map<String, Object> headers) {
        if (EmptyUtils.isNotEmpty(headers)) {
            this.headers.putAll(headers);
        }
    }

    public HeaderInterceptor addHeader(@NonNull String key, @Nullable Object value) {
        headers.put(key, value);
        return this;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (EmptyUtils.isNotEmpty(headers)) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return chain.proceed(builder.build());
    }

}
