package com.liamma.commons.utils;

import android.util.Log;

import com.liamma.commons.Constants;


/**
 * A simple Logger for Android.
 * Created by Liam on 2017/12/6.
 */
public final class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final boolean DEBUG = Constants.LOG_DEBUG_ENABLE;
    private static final String TAG = "LogUtils";

    private static String[] prefix = {". ", " ."};
    private static int index = 0;

    // Changes log's tag to fix "line wrap" problem of logs.
    private static String getChangedTag(String tag) {
        index = index ^ 1;
        return prefix[index] + tag;
    }

    // Returns a string which consist of class name and method name and so on.
    private static String getLogInfo() {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        int offset = getStackOffset(elements);
        StackTraceElement element = elements[offset];

        return "[" + element.getClassName() +
                "." + element.getMethodName() +
                "() :: " + element.getLineNumber() +
                "]";
    }

    // Determines the start point stack trace.
    private static int getStackOffset(StackTraceElement[] elements) {
        String name = LogUtils.class.getName();
        int size = elements.length;

        for (int i = 0; i < size; i++) {
            if (name.equals(elements[i].getClassName())
                    && !name.equals(elements[i + 1].getClassName())) {
                return ++i;
            }
        }
        return 0;
    }

    /**
     * Outputs log of level "i".
     * Only use when you want to show logs in the release versions.
     */
    public static void ri(String log) {
        Log.i(TAG, log);
    }

    /**
     * Outputs log of level "e".
     * Only use when you want to show logs in the release versions.
     */
    public static void re(String log) {
        Log.e(TAG, log);
    }

    // Below methods are for debugging and can be turned off by set DEBUG false.

    public static void i(String log) {
        i(TAG, log);
    }

    public static void i(String tag, String log) {
        if (DEBUG) {
            Log.println(Log.INFO, getChangedTag(tag), getLogInfo());
            Log.println(Log.INFO, getChangedTag(tag), log);
        }
    }

    public static void d(String log) {
        d(TAG, log);
    }

    public static void d(String tag, String log) {
        if (DEBUG) {
            Log.println(Log.DEBUG, getChangedTag(tag), getLogInfo());
            Log.println(Log.DEBUG, getChangedTag(tag), log);
        }
    }

    public static void v(String log) {
        v(TAG, log);
    }

    public static void v(String tag, String log) {
        if (DEBUG) {
            Log.println(Log.VERBOSE, getChangedTag(tag), getLogInfo());
            Log.println(Log.VERBOSE, getChangedTag(tag), log);
        }
    }

    public static void e(String log) {
        e(TAG, log);
    }

    public static void e(String tag, String log) {
        if (DEBUG) {
            Log.println(Log.ERROR, getChangedTag(tag), getLogInfo());
            Log.println(Log.ERROR, getChangedTag(tag), log);
        }
    }

    /**
     * Same as method {@code dAll(String tag, String log)}.
     */
    public static void dAll(String log) {
        dAll(TAG, log);
    }

    /**
     * Outputs all log in console window.
     */
    public static void dAll(String tag, String log) {
        if (DEBUG) {
            Log.println(Log.DEBUG, getChangedTag(tag), getLogInfo());

            if (log.length() >= 3000) {
                Log.println(Log.DEBUG, getChangedTag(tag), log.substring(0, 3000));
                log = log.substring(3000);
            }
            Log.println(Log.DEBUG, getChangedTag(tag), log);
        }
    }

}
