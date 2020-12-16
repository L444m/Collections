package com.liamma.commons.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Liam on 2019/3/14
 */
public final class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    /**
     * @return Application context.
     */
    public static Application getApp() {
        return null;
    }

    public static String getAppName(Context context) {
        return null;
    }

    public static String getPackageName(Context context) {
        return null;
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
