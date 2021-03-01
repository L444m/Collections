package com.liamma.commons.http.okhttp;

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

    private synchronized OkHttpClient createOkHttpClient(List<Interceptor> list) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(HttpConfigs.DEFAULT_CONNECT_TIME, TimeUnit.MILLISECONDS);
        builder.readTimeout(HttpConfigs.DEFAULT_READ_TIME, TimeUnit.MILLISECONDS);
        builder.writeTimeout(HttpConfigs.DEFAULT_WRITE_TIME, TimeUnit.MILLISECONDS);

        if (EmptyUtils.isNotEmpty(list)) {
            for (Interceptor interceptor : list) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }

    // Create a default OkHttpClient which has only a log interceptor.
    private synchronized OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        List<Interceptor> list = new ArrayList<>();
        list.add(httpLoggingInterceptor);
        return createOkHttpClient(list);
    }

    public OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = createOkHttpClient();
        }
        return okHttpClient;
    }

    public OkHttpClient getNewOkHttpClient(List<Interceptor> interceptors) {
        return createOkHttpClient(interceptors);
    }

}
