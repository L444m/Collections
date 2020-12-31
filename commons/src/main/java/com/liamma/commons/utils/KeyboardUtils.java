package com.liamma.commons.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * Keyboard Utils.
 * Created by Liam on 2019/10/31.
 */
public final class KeyboardUtils {

    private KeyboardUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Hide soft keyboard in an Activity.
     * Be aware this method may dose not work when called from {@code Fragment}.
     *
     * @param activity Target Activity
     */
    public static void hideSoftKeyboard(@NonNull Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }

        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Hide soft keyboard.
     *
     * @param context Context
     * @param view    View
     */
    public static void hideSoftKeyboard(@NonNull Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Hide soft keyboard from a Fragment.
     *
     * @param fragment Fragment
     */
    public static void hideSoftKeyboard(@NonNull Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            LogUtils.e("activity == null. cannot get activity from fragment.");
            return;
        }

        Window window = activity.getWindow();
        if (window == null) {
            // cannot get window if current activity is not visible.
            LogUtils.e("window == null. current activity is not visible.");
            return;
        }

        View view = window.getDecorView();
        final InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
