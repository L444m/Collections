package com.liamma.commons.log;

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

    public static void addLogger(ILog logger) {
        LoggerManager.getInstance().addCustomLogger(logger);
    }

    public static void addLogger(int index, ILog logger) {
        LoggerManager.getInstance().addCustomLogger(index, logger);
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

    public static void d(Class<? extends ILog> clazz, String tag, String message) {
        LoggerManager.getInstance().getLogger(clazz).i(tag, message);
    }

    public static void d(String tag, String message) {
        LoggerManager.getInstance().getLogger().d(tag, message);
    }

    public static void d(String message) {
        d(TAG, message);
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

}
