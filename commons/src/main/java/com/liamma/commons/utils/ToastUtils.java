package com.liamma.commons.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;


/**
 * Utility methods for showing toast.
 * Created by Liam on 2018/7/20.
 */
public final class ToastUtils {

    private ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Show toast in long duration.
     *
     * @param context Context
     * @param msg     String toast content
     */
    public static void showLong(@NonNull Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Show toast in long duration.
     *
     * @param context Context
     * @param resId   Integer, String resource id
     */
    public static void showLong(@NonNull Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }

    /**
     * Show toast in short duration.
     *
     * @param context Context
     * @param msg     String toast content
     */
    public static void showShort(@NonNull Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show toast in short duration.
     *
     * @param context Context
     * @param resId   Integer, String resource id
     */
    public static void showShort(@NonNull Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

}
