package com.liamma.commons.utils;

import android.view.View;

import androidx.annotation.NonNull;


/**
 * Created by Liam on 2019/7/29.
 */
public final class ClickUtils {

    public static final String CLICK_TAG = "ClickUtils";
    public static final long CLICK_DURATION = 200;

    private ClickUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    public static boolean isValid(@NonNull View view, long duration) {
        Object tag = view.getTag();
        long current = System.currentTimeMillis();

        if (tag instanceof Long) {
            long previous = (long) tag;
            if ((current - previous) >= duration) {
                view.setTag(current);
                return true;
            } else {
                return false;
            }
        } else {
            view.setTag(current);
            return true;
        }
    }

    public static boolean isValid(@NonNull View view) {
        return isValid(view, CLICK_DURATION);
    }

    public static boolean isFastClick(@NonNull View view, long duration) {
        return false;
    }

    public static void testNull(Object o) {
        if (o instanceof String) {
            System.out.println((String) o);
        } else {
            System.out.println("it is not String.");
        }
    }

    public static void main(String[] args) {
        testNull(null);
    }

}
