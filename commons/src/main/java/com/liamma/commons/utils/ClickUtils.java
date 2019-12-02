package com.liamma.commons.utils;

import android.view.View;

import androidx.annotation.Nullable;

import com.liamma.commons.R;


/**
 * Created by Liam on 2019/7/29.
 */
public final class ClickUtils {

    private static final int TAG_CLICK = R.id.tag_clicked_time;
    public static final long CLICK_DURATION = 200;

    private ClickUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static boolean isValid(@Nullable final View view, final long duration) {
        if (view == null) return false;
        // object tag could be null.
        Object tag = view.getTag(TAG_CLICK);
        long current = System.currentTimeMillis();

        if (tag instanceof Long) {
            long previous = (long) tag;
            if ((current - previous) >= duration) {
                view.setTag(TAG_CLICK, current);
                return true;
            } else {
                return false;
            }
        } else {
            view.setTag(TAG_CLICK, current);
            return true;
        }
    }

    /**
     * Whether this click action is valid.
     *
     * @param view     the view on which is clicked
     * @param duration time duration
     */
    public static boolean isValidClick(@Nullable final View view, final long duration) {
        return isValid(view, duration);
    }

    /**
     * Whether this click action is valid.
     *
     * @param view the view on which is clicked
     */
    public static boolean isValidClick(@Nullable final View view) {
        return isValidClick(view, CLICK_DURATION);
    }

    /**
     * Whether this click is a fast click which should be ignored.
     *
     * @param view     the view on which is clicked
     * @param duration time duration
     */
    public static boolean isFastClick(@Nullable final View view, final long duration) {
        return !isValid(view, duration);
    }

    /**
     * Whether this click is a fast click which should be ignored.
     *
     * @param view the view on which is clicked
     */
    public static boolean isFastClick(@Nullable final View view) {
        return isFastClick(view, CLICK_DURATION);
    }

}
