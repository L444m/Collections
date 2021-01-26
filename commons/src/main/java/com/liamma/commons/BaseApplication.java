package com.liamma.commons;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/1/10 13:59
 * DESCRIPTION: This is a customized Application that anything like setting configs, initialization can be done
 * in it when app is starting up.
 */
public class BaseApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static BaseApplication instance = null;
    private Context context;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = this.getApplicationContext();
    }

    public Context getContext() {
        return context;
    }

}
