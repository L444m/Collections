package com.liamma.commons.http.interceptor;

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
 * Interceptor for adding headers in requests.
 * Created by Liam on 2018/7/19.
 */
public class HeaderInterceptor implements Interceptor {

    private Map<String, Object> headers = new LinkedHashMap<>();

    public HeaderInterceptor() {
    }

    public HeaderInterceptor(@Nullable Map<String, Object> headers) {
        if (!EmptyUtils.isEmpty(headers)) {
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

        if (!EmptyUtils.isEmpty(headers)) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        return chain.proceed(builder.build());
    }

}
