package com.liamma.collections.http;

import com.liamma.collections.bean.Version;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * ZhiHu api interface.
 * Created by Liam on 2018/7/19
 */
public interface ApiInterface {

    String BASE_URL = "https://news-at.zhihu.com/api/4/version/android/";

    @GET("2.3.0")
    Observable<Version> getVersion();

}
