package com.liamma.commons.utils;

import android.view.View;

import androidx.annotation.Nullable;

import com.liamma.commons.R;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/7/29 10:43
 * DESCRIPTION:
 */
public final class ClickUtils {

    private static final int TAG_LAST_CLICK_TIME = R.id.tag_last_click_time;
    // Default time interval is 200ms.
    public static final long CLICK_INTERVAL = 200L;

    private ClickUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Whether this click event is valid.
     *
     * @param view the view on which is clicked
     */
    public static boolean isValid(@Nullable final View view) {
        return isValid(view, CLICK_INTERVAL);
    }

    /**
     * Whether this click event is valid.
     *
     * @param view     the view on which is clicked
     * @param interval time interval
     * @return {@code true} means click event is valid and ok to respond to, otherwise {@code false}.
     */
    public static boolean isValid(@Nullable final View view, final long interval) {
        if (view == null) {
            return false;
        }

        Object tag = view.getTag(TAG_LAST_CLICK_TIME);
        long current = System.currentTimeMillis();
        if (tag instanceof Long) {
            long previous = (long) tag;
            if ((current - previous) >= interval) {
                view.setTag(TAG_LAST_CLICK_TIME, current);
                return true;
            } else {
                return false;
            }
        } else {
            view.setTag(TAG_LAST_CLICK_TIME, current);
            return true;
        }
    }

}
