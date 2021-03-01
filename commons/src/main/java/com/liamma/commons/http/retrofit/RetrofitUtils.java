package com.liamma.commons.http.retrofit;

import androidx.annotation.NonNull;

import com.liamma.commons.Constants;

/**
 * Retrofit 帮助类.
 * 兼容多个 OkHttpClient / RetrofitManager 的情况。
 * Created by Liam on 2018/7/17.
 */
public class RetrofitUtils {

    public static <T> T createApi(@NonNull Class<T> clazz) {
        return createApi(clazz, Constants.BASE_URL, false);
    }

    public static <T> T createApi(@NonNull Class<T> clazz, @NonNull String baseUrl) {
        return createApi(clazz, baseUrl, false);
    }

    // 暂时没有处理 security。
    public static <T> T createApi(@NonNull Class<T> clazz, @NonNull String baseUrl, boolean security) {
        return RetrofitManager.getInstance().getRetrofit(baseUrl).create(clazz);
    }

}
