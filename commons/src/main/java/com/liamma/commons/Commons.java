package com.liamma.commons;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.log.LogUtils;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/8 9:29
 * DESCRIPTION: Initiates this library.
 */
public final class Commons {

    private static volatile Commons instance = null;
    // Instance of Application context.
    private Context appContext;

    private Commons() {
    }

    public static Commons getInstance() {
        if (instance == null) {
            synchronized (Commons.class) {
                if (instance == null) {
                    instance = new Commons();
                }
            }
        }
        return instance;
    }

    /**
     * Init this singleton class with a Context object.
     * An IllegalArgumentException exception would occurred if the context is null.
     *
     * @param context Context
     */
    public static synchronized void init(Context context) {
        if (context == null) {
            LogUtils.e("Context is null, wrong argument.");
            throw new IllegalArgumentException("Context is null");
        }
        Commons.getInstance().setAppContext(context.getApplicationContext());
    }

    /**
     * Returns the stored application context instance.
     * If stored application context is null which means that this class has not been initialized,
     * an IllegalStateException exception would be thrown out.
     *
     * @return Application context
     */
    @NonNull
    public static Context getApp() {
        Context appContext = Commons.getInstance().getAppContext();
        if (appContext == null) {
            LogUtils.e("Commons has not been initialized.");
            throw new IllegalStateException("Not been initialized.");
        }
        return appContext;
    }

    @Nullable
    public Context getAppContext() {
        return appContext;
    }

    /**
     * Sets value of appContext, it can only be involved by {@code init()} method to avoid multi-times
     * assigning.
     */
    private void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

}
