package com.liamma.commons.utils;

import android.content.Context;
import android.util.TypedValue;

import androidx.annotation.NonNull;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/8/31 15:11
 * DESCRIPTION:
 */
public final class DensityUtils {

    private DensityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp to px
     */
    public static int dp2px(@NonNull final Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics());
    }

    /**
     * sp to px
     */
    public static int sp2px(@NonNull final Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, context.getResources().getDisplayMetrics());
    }

    /**
     * px to dp
     */
    public static float px2dp(@NonNull final Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (px / scale);
    }

    /**
     * px to sp
     */
    public static float px2sp(@NonNull final Context context, float px) {
        return (px / context.getResources().getDisplayMetrics().scaledDensity);
    }

    /**
     * Returns screen width in pixels.
     */
    public static float getDeviceWidth(@NonNull final Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * Returns screen height in pixels.
     */
    public static float getDeviceHeight(@NonNull final Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

}
