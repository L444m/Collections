package com.liamma.commons.log;

import com.liamma.commons.BuildConfig;
import com.liamma.commons.Constants;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/22 14:02
 * DESCRIPTION: Utility class for using log function easily.
 */
public final class LogUtils {

    public static final String TAG = "LogUtils";

    private LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated...");
    }

    @SuppressWarnings("ConstantConditions")
    public static boolean isDebugEnable() {
        if (Constants.LOG_DEBUG_ENABLE != null) {
            return Constants.LOG_DEBUG_ENABLE;
        } else {
            return BuildConfig.DEBUG;
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static boolean isInfoEnable() {
        if (Constants.LOG_INFO_ENABLE != null) {
            return Constants.LOG_INFO_ENABLE;
        } else {
            return BuildConfig.DEBUG;
        }
    }

    public static void addLogger(ILog logger) {
        LoggerManager.getInstance().addCustomLogger(logger);
    }

    public static void addLogger(int index, ILog logger) {
        LoggerManager.getInstance().addCustomLogger(index, logger);
    }

    public static void v(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).v(tag, message);
    }

    public static void v(String tag, String message) {
        LoggerManager.getInstance().getLogger().v(tag, message);
    }

    public static void v(String message) {
        v(TAG, message);
    }

    public static void d(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).d(tag, message);
    }

    public static void d(String tag, String message) {
        LoggerManager.getInstance().getLogger().d(tag, message);
    }

    public static void d(String message) {
        d(TAG, message);
    }

    public static void i(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).i(tag, message);
    }

    public static void i(String tag, String message) {
        LoggerManager.getInstance().getLogger().i(tag, message);
    }

    public static void i(String message) {
        i(TAG, message);
    }

    public static void w(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).w(tag, message);
    }

    public static void w(String tag, String message) {
        LoggerManager.getInstance().getLogger().w(tag, message);
    }

    public static void w(String message) {
        w(TAG, message);
    }

    public static void e(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).e(tag, message);
    }

    public static void e(String tag, String message) {
        LoggerManager.getInstance().getLogger().e(tag, message);
    }

    public static void e(String message) {
        e(TAG, message);
    }

    public static void wtf(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).wtf(tag, message);
    }

    public static void wtf(String tag, String message) {
        LoggerManager.getInstance().getLogger().wtf(tag, message);
    }

    public static void wtf(String message) {
        wtf(TAG, message);
    }

}
