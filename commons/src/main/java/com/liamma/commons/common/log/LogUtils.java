package com.liamma.commons.common.log;

// 增加 priority 的设置。
public final class LogUtils {

    public static final String TAG = "LogUtils";

    private LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated...");
    }

    public static void setLogger(ILog logger) {
        if (logger == null) return;
        LoggerManager.getInstance().setCustomLogger(logger);
    }

    public static void i(String tag, String message) {
        LoggerManager.getInstance().getLogger().i(tag, message);
    }

    public static void d(String tag, String message) {
        LoggerManager.getInstance().getLogger().d(tag, message);
    }

    public static void v(String tag, String message) {
        LoggerManager.getInstance().getLogger().v(tag, message);
    }

    public static void f(String tag, String message) {
        LoggerManager.getInstance().getLogger().f(tag, message);
    }

}
