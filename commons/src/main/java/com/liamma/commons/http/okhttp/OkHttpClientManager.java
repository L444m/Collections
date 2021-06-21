package com.liamma.commons.http.okhttp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.http.HttpConfigs;
import com.liamma.commons.http.okhttp.interceptor.HttpLoggingInterceptor;
import com.liamma.commons.utils.EmptyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/16 00:00
 * DESCRIPTION: This class is used to create OkHttpClient instance.
 */
public class OkHttpClientManager {

    private static volatile OkHttpClientManager instance = null;
    private OkHttpClient okHttpClient;

    private OkHttpClientManager() {
        createOkHttpClient();
    }

    public static OkHttpClientManager getInstance() {
        if (instance == null) {
            synchronized (OkHttpClientManager.class) {
                if (instance == null) {
                    instance = new OkHttpClientManager();
                }
            }
        }
        return instance;
    }

    /**
     * Creates a new OkHttpClient instance.
     */
    private synchronized OkHttpClient createOkHttpClient(@Nullable final List<Interceptor> interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(HttpConfigs.DEFAULT_CONNECT_TIME, TimeUnit.MILLISECONDS);
        builder.readTimeout(HttpConfigs.DEFAULT_READ_TIME, TimeUnit.MILLISECONDS);
        builder.writeTimeout(HttpConfigs.DEFAULT_WRITE_TIME, TimeUnit.MILLISECONDS);

        if (EmptyUtils.isNotEmpty(interceptors)) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }

    /**
     * Creates a default OkHttpClient instance which has only a log interceptor.
     */
    private synchronized OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        List<Interceptor> list = new ArrayList<>();
        list.add(loggingInterceptor);
        return createOkHttpClient(list);
    }

    /**
     * Returns the default OkHttpClient instance.
     *
     * @return OkHttpClient
     */
    @NonNull
    public OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = createOkHttpClient();
        }
        return okHttpClient;
    }

    /**
     * Returns a new OkHttpClient instance.
     *
     * @param interceptors Interceptor list
     * @return OkHttpClient
     */
    public OkHttpClient getOkHttpClient(@Nullable List<Interceptor> interceptors) {
        return createOkHttpClient(interceptors);
    }

}
