package com.liamma.commons.http;

import androidx.annotation.NonNull;

import com.liamma.commons.Constants;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * Retrofit 帮助类.
 * 兼容多个 OkHttpClient / RetrofitClient 的情况。
 * Created by Liam on 2018/7/17.
 */
public class RetrofitHelper {

    private static volatile RetrofitHelper instance = null;

    private Map<String, OkHttpClient> httpClientMap = new HashMap<>();
    private Map<String, RetrofitClient> retrofitClientMap = new HashMap<>();

    private RetrofitHelper() {
    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }

    public static <T> T createApi(@NonNull Class<T> clazz) {
        return createApi(clazz, Constants.BASE_URL, false);
    }

    // 暂时没有处理 security 。
    public static <T> T createApi(@NonNull Class<T> clazz,
                                  @NonNull String baseUrl,
                                  boolean security) {
        return RetrofitClient.getInstance().getRetrofit(baseUrl).create(clazz);
    }

}
