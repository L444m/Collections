package com.liamma.commons.log;

import android.util.Log;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/15 11:30
 * DESCRIPTION: A simple Logger for Android.
 */
public class DefaultLogger implements ILog {

    private static final String TAG = "DefaultLogger";

    private final String[] prefix = {". ", " ."};
    private int index = 0;

    /**
     * Changes log's tag to fix "line wrap" problem of logs.
     */
    private String getChangedTag(String tag) {
        index = index ^ 1;
        return prefix[index] + tag;
    }

    /**
     * Returns a string which consist of class name and method name and so on.
     */
    private String getLogInfo() {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        int offset = getStackOffset(elements);
        StackTraceElement element = elements[offset];

        return "[" + element.getClassName() +
                "." + element.getMethodName() +
                "() :: " + element.getLineNumber() +
                "]";
    }

    /**
     * Determines the start point stack trace.
     */
    private static int getStackOffset(StackTraceElement[] elements) {
        String name = DefaultLogger.class.getName();
        int size = elements.length;

        for (int i = 0; i < size; i++) {
            if (name.equals(elements[i].getClassName())
                    && !name.equals(elements[i + 1].getClassName())) {
                return ++i;
            }
        }
        return 0;
    }

    @Override
    public void v(String tag, String log) {
        Log.println(Log.VERBOSE, getChangedTag(tag), getLogInfo());
        Log.println(Log.VERBOSE, getChangedTag(tag), log);
    }

    @Override
    public void v(String tag, String log, Throwable tr) {
    }

    @Override
    public void d(String tag, String log) {
        Log.println(Log.DEBUG, getChangedTag(tag), getLogInfo());
        Log.println(Log.DEBUG, getChangedTag(tag), log);
    }

    @Override
    public void d(String tag, String log, Throwable tr) {
    }

    @Override
    public void i(String tag, String log) {
        Log.println(Log.INFO, getChangedTag(tag), getLogInfo());
        Log.println(Log.INFO, getChangedTag(tag), log);
    }

    @Override
    public void i(String tag, String log, Throwable tr) {
    }

    @Override
    public void w(String tag, String log) {
        Log.println(Log.WARN, getChangedTag(tag), getLogInfo());
        Log.println(Log.WARN, getChangedTag(tag), log);
    }

    @Override
    public void w(String tag, String log, Throwable tr) {
    }

    @Override
    public void e(String tag, String log) {
        Log.println(Log.ERROR, getChangedTag(tag), getLogInfo());
        Log.println(Log.ERROR, getChangedTag(tag), log);
    }

    @Override
    public void e(String tag, String log, Throwable tr) {
    }

    @Override
    public void wtf(String tag, String log) {
    }

    @Override
    public void wtf(String tag, String log, Throwable tr) {
    }

    /**
     * Outputs all log in console window.
     */
    public void dAll(String tag, String log) {
        // only for testing.
        boolean DEBUG = true;
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
