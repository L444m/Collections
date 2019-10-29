package com.liamma.commons;

import android.app.Application;
import android.content.Context;

/**
 * Application class for this library.
 * Created by Liam on 2019/1/10
 */
public class App extends Application {

    private static App instance = null;

    private Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
    }

    public static App getInstance() {
        return instance;
    }

    public Context getContext() {
        return context;
    }

}
