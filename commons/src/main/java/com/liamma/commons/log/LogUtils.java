package com.liamma.commons.log;

import androidx.annotation.Nullable;

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
        throw new UnsupportedOperationException("cannot be instantiated.");
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

    public static void addLogger(@Nullable ILog logger) {
        LoggerManager.getInstance().addLogger(logger);
    }

    public static void addLogger(String loggerName, @Nullable ILog logger) {
        LoggerManager.getInstance().addLogger(loggerName, logger);
    }

    // ------------------- LOG level : verbose ------------------- //

    public static void v(String log) {
        v(TAG, log);
    }

    public static void v(String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger().v(tag, log);
        }
    }

    public static void v(Class<? extends ILog> clazz, String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger(clazz).v(tag, log);
        }
    }

    public static void v(String tag, String log, Throwable tr) {
    }

    // ------------------- LOG level : debug ------------------- //

    public static void d(String log) {
        d(TAG, log);
    }

    public static void d(String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger().d(tag, log);
        }
    }

    public static void d(Class<? extends ILog> clazz, String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger(clazz).d(tag, log);
        }
    }

    public static void d(String tag, String log, Throwable tr) {
    }

    // ------------------- LOG level : Info ------------------- //

    public static void i(String log) {
        i(TAG, log);
    }

    public static void i(String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger().i(tag, log);
        }
    }

    public static void i(Class<? extends ILog> clazz, String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger(clazz).i(tag, log);
        }
    }

    public static void i(String tag, String log, Throwable tr) {
    }

    // ------------------- LOG level : Warn ------------------- //

    public static void w(String log) {
        w(TAG, log);
    }

    public static void w(String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger().w(tag, log);
        }
    }

    public static void w(Class<? extends ILog> clazz, String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger(clazz).w(tag, log);
        }
    }

    public static void w(String tag, String log, Throwable tr) {
    }

    // ------------------- LOG level : Error ------------------- //

    public static void e(String log) {
        e(TAG, log);
    }

    public static void e(String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger().e(tag, log);
        }
    }

    public static void e(Class<? extends ILog> clazz, String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger(clazz).e(tag, log);
        }
    }

    public static void e(String tag, String log, Throwable tr) {
    }

    // ------------------- LOG level : Asset ------------------- //

    public static void wtf(String log) {
        wtf(TAG, log);
    }

    public static void wtf(String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger().wtf(tag, log);
        }
    }

    public static void wtf(Class<? extends ILog> clazz, String tag, String log) {
        if (isDebugEnable()) {
            LoggerManager.getInstance().getLogger(clazz).wtf(tag, log);
        }
    }

    public static void wtf(String tag, String log, Throwable tr) {
    }

}
