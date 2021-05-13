package com.liamma.commons.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.BuildConfig;
import com.liamma.commons.Commons;
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

    // maybe return null.
    public static String getPackageName() {
        return Commons.getApp().getPackageName();
    }

    public static PackageManager getPackageManager() {
        return Commons.getApp().getPackageManager();
    }

    /**
     * Returns the {@link PackageInfo} object of this application.
     */
    @Nullable
    public static PackageInfo getPackageInfo() {
        return getPackageInfo(getPackageName());
    }

    /**
     * Returns a {@link PackageInfo} object of the specified package name.
     */
    @Nullable
    public static PackageInfo getPackageInfo(@Nullable final String packageName) {
        if (StringUtils.isBlank(packageName)) {
            LogUtils.e("Argument of packageName is empty or blank.");
            return null;
        }
        try {
            return getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e("Cannot get package info, wrong package name.");
            return null;
        }
    }

    /**
     * Returns the {@link ApplicationInfo} object of this application.
     */
    @Nullable
    public static ApplicationInfo getApplicationInfo() {
        return getApplicationInfo(getPackageName());
    }

    /**
     * Returns an {@link ApplicationInfo} object of the specified package name.
     */
    @Nullable
    public static ApplicationInfo getApplicationInfo(@Nullable final String packageName) {
        if (StringUtils.isBlank(packageName)) {
            LogUtils.e("Argument of packageName is empty or blank.");
            return null;
        }
        try {
            return getPackageManager().getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e("Cannot get application info, wrong package name.");
            return null;
        }
    }

    @NonNull
    public static String getVersionName() {
        return getVersionName(getPackageName());
    }

    @NonNull
    public static String getVersionName(@Nullable final String packageName) {
        PackageInfo info = getPackageInfo(packageName);
        return info == null ? "" : info.versionName;
    }

    public static int getVersionCode() {
        return getVersionCode(getPackageName());
    }

    public static int getVersionCode(@Nullable final String packageName) {
        PackageInfo info = getPackageInfo(packageName);
        return info == null ? -1 : info.versionCode;
    }

    public static long getLongVersionCode() {
        return getLongVersionCode(getPackageName());
    }

    public static long getLongVersionCode(@Nullable final String packageName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            PackageInfo info = getPackageInfo(packageName);
            return info == null ? -1L : info.getLongVersionCode();
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
        ApplicationInfo appInfo = getApplicationInfo(packageName);
        return appInfo == null ? "" : appInfo.loadLabel(getPackageManager()).toString();
    }

    @Nullable
    public static Drawable getAppIcon() {
        return getAppIcon(getPackageName());
    }

    @Nullable
    public static Drawable getAppIcon(@Nullable final String packageName) {
        ApplicationInfo appInfo = getApplicationInfo(packageName);
        return appInfo == null ? null : appInfo.loadIcon(getPackageManager());
    }

    @Nullable
    public static Drawable getAppLogo() {
        return getAppLogo(getPackageName());
    }

    @Nullable
    public static Drawable getAppLogo(@Nullable final String packageName) {
        ApplicationInfo appInfo = getApplicationInfo(packageName);
        return appInfo == null ? null : appInfo.loadLogo(getPackageManager());
    }

    public static String[] getMetaData(@Nullable final String... keys) {
        return null;
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
     * Whether the specified application is installed or not.
     */
    public static boolean isAppInstalled(@Nullable final String packageName) {
        if (StringUtils.isBlank(packageName)) {
            return false;
        }
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        for (PackageInfo packageInfo : packages) {
            if (packageName.equals(packageInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Whether the specified application is a system app.
     * Do not need to check "this app", because you know you app isn't. LOL
     */
    public static boolean isAppSystem(@Nullable final String packageName) {
        ApplicationInfo appInfo = getApplicationInfo(packageName);
        return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    /**
     * Whether the specified application is in debug mode or not.
     * This method is used for other applications, use {@link AppUtils#isDebug()} to check this app.
     */
    public static boolean isAppDebug(@Nullable final String packageName) {
        ApplicationInfo appInfo = getApplicationInfo(packageName);
        return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

    public static boolean isAppRoot(@Nullable final String packageName) {
        // To be completed.
        return false;
    }

    public static void installApp(@Nullable final String filePath) {
        File file = FileUtils.getFile(filePath);
        if (file == null) {
            return;
        }

    }

    public static void installApp(@Nullable final File file) {

    }

}
