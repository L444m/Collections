package com.liamma.commons.http;

import com.liamma.commons.http.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * 封装 OkHttpClient Builder。
 * Created by Liam on 2018/7/16.
 */
public class HttpClient {

    private static volatile HttpClient instance = null;
    private OkHttpClient.Builder builder;

    private HttpClient() {
        initDefaultBuilder();
    }

    public static HttpClient getInstance() {
        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new HttpClient();
                }
            }
        }
        return instance;
    }

    private void initDefaultBuilder() {
        builder = new OkHttpClient.Builder();

        builder.connectTimeout(HttpConfigs.connectTimeout, TimeUnit.MILLISECONDS);
        builder.readTimeout(HttpConfigs.readTimeout, TimeUnit.MILLISECONDS);
        builder.writeTimeout(HttpConfigs.writeTimeout, TimeUnit.MILLISECONDS);

        // builder.addInterceptor(new HeaderInterceptor());

        // Logging interceptor.
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
    }

    public OkHttpClient.Builder getBuilder() {
        return builder;
    }

    public OkHttpClient getOkHttpClient() {
        return builder.build();
    }

}
