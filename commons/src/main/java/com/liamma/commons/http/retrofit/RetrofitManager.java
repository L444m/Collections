package com.liamma.commons.http.retrofit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.http.okhttp.OkHttpClientManager;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/16 00:00
 * DESCRIPTION: A manager class caches all Retrofit instance, and supports http request with different BaseUrl.
 */
public class RetrofitManager {

    private static volatile RetrofitManager instance = null;
    private HashMap<String, Retrofit> retrofitMap;

    private RetrofitManager() {
        initRetrofitManager();
    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    private void initRetrofitManager() {
        if (retrofitMap == null) {
            retrofitMap = new HashMap<>();
        } else {
            retrofitMap.clear();
        }
    }

    private synchronized Retrofit createRetrofit(@NonNull String baseUrl) {
        return createRetrofit(baseUrl, OkHttpClientManager.getInstance().getOkHttpClient());
    }

    private synchronized Retrofit createRetrofit(@NonNull String baseUrl, @Nullable OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            okHttpClient = OkHttpClientManager.getInstance().getOkHttpClient();
        }
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();
    }

    public Retrofit getRetrofit(@NonNull String baseUrl) {
        Retrofit retrofit = retrofitMap.get(baseUrl);
        if (retrofit == null) {
            retrofit = createRetrofit(baseUrl);
        }
        retrofitMap.put(baseUrl, retrofit);
        return retrofit;
    }

}
