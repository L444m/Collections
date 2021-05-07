package com.liamma.commons.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.BaseApplication;
import com.liamma.commons.BuildConfig;
import com.liamma.commons.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/3/14 14:35
 * DESCRIPTION: Utility methods about information of android application.
 */
public final class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    /**
     * Whether this app is in debug mode.
     *
     * @return {@code true} in debug mode, otherwise {@code false}.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isDebug() {
        if (Constants.DEBUG != null) {
            return Constants.DEBUG;
        } else {
            return BuildConfig.DEBUG;
        }
    }

    /**
     * This method <strong>must</> return a non-null Application object, otherwise lots of other
     * methods would throw NPE.
     */
    @NonNull
    public static Application getApplication() {
        Application application = BaseApplication.getInstance();
        if (application == null) {
            LogUtils.e("Application object is null.");
            throw new IllegalStateException("Application is null");
        }
        return application;
    }

    public static String getPackageName() {
        return getApplication().getPackageName();
    }

    public static PackageManager getPackageManager() {
        return getApplication().getPackageManager();
    }

    /**
     * Returns the PackageInfo object of this application.
     */
    @Nullable
    public static PackageInfo getPackageInfo() {
        return getPackageInfo(getPackageName());
    }

    /**
     * Returns a PackageInfo object of the specified package name.
     */
    @Nullable
    public static PackageInfo getPackageInfo(@Nullable final String packageName) {
        if (StringUtils.isBlank(packageName)) {
            LogUtils.e("Parameter of packageName is empty or blank.");
            return null;
        }
        try {
            return getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e("Cannot get package info, wrong package name.");
            return null;
        }
    }

    @NonNull
    public static String getVersionName() {
        return getVersionName(getPackageName());
    }

    @NonNull
    public static String getVersionName(@Nullable final String packageName) {
        PackageInfo packageInfo = getPackageInfo(packageName);
        return packageInfo == null ? "" : packageInfo.versionName;
    }

    public static int getVersionCode() {
        return getVersionCode(getPackageName());
    }

    public static int getVersionCode(@Nullable final String packageName) {
        PackageInfo packageInfo = getPackageInfo(packageName);
        return packageInfo == null ? -1 : packageInfo.versionCode;
    }

    public static long getLongVersionCode() {
        return getLongVersionCode(getPackageName());
    }

    public static long getLongVersionCode(@Nullable final String packageName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            PackageInfo packageInfo = getPackageInfo(packageName);
            return packageInfo == null ? -1L : packageInfo.getLongVersionCode();
        } else {
            LogUtils.e("App version must greater than or equal to 28 to get long version code.");
            return -1L;
        }
    }

    @NonNull
    public static String getAppName() {
        return getAppName(getPackageName());
    }

    @NonNull
    public static String getAppName(@Nullable final String packageName) {
        PackageInfo packageInfo = getPackageInfo(packageName);
        if (packageInfo == null) {
            return "";
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return "";
        }
        return applicationInfo.loadLabel(getPackageManager()).toString();
    }

    @Nullable
    public static Drawable getAppIcon() {
        return getAppIcon(getPackageName());
    }

    @Nullable
    public static Drawable getAppIcon(@Nullable final String packageName) {
        PackageInfo packageInfo = getPackageInfo(packageName);
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return null;
        }
        return applicationInfo.loadIcon(getPackageManager());
    }

    @Nullable
    public static Drawable getAppLogo() {
        return getAppLogo(getPackageName());
    }

    @Nullable
    public static Drawable getAppLogo(@Nullable final String packageName) {
        PackageInfo packageInfo = getPackageInfo(packageName);
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return null;
        }
        return applicationInfo.loadLogo(getPackageManager());
    }

    /**
     * Gets all installed packages which exclude system apps.
     */
    @NonNull
    public static List<PackageInfo> getInstalledPackages() {
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        List<PackageInfo> list = new ArrayList<>();
        for (PackageInfo packageInfo : packages) {
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                list.add(packageInfo);
            }
        }
        return list;
    }

    /**
     *
     */
    public static boolean isAppInstalled(@Nullable final String packageName) {
        return false;
    }

    public static void installApp(@Nullable final String filePath) {

    }

    public static void installApp(@Nullable final File file) {

    }

}
