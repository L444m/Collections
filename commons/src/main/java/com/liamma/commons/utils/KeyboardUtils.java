package com.liamma.commons.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

/**
 * Keyboard Utils.
 * Created by Liam on 2019/10/31.
 */
public final class KeyboardUtils {

    private KeyboardUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void hideSoftKeyboard(@NonNull Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

}
