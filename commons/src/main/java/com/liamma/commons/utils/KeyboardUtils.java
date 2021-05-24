package com.liamma.commons.utils;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.log.LogUtils;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/10/31 15:55
 * DESCRIPTION: Keyboard Utils.
 */
public final class KeyboardUtils {

    private KeyboardUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Hide soft keyboard in an Activity.
     * Be aware this method may dose not work when called from {@code Fragment}.
     */
    public static void hideKeyboard(@Nullable final Activity activity) {
        if (activity == null) {
            return;
        }
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
     * Hide keyboard.
     */
    public static void hideKeyboard(@Nullable final Context context, @Nullable View view) {
        if (context == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Hide soft keyboard from a Fragment.
     */
    public static void hideKeyboard(@NonNull Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            LogUtils.e("activity is null. cannot get activity from fragment.");
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
