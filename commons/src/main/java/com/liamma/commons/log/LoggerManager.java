package com.liamma.commons.log;

import android.util.Log;

public class LoggerManager {

    public static final String TAG = "LoggerManager";

    public static volatile LoggerManager instance = null;
    private ILog defaultLogger = null;
    private ILog customLogger = null;

    private LoggerManager() {
        if (defaultLogger == null) {
            defaultLogger = new DefaultLogger();
        }
    }

    public static LoggerManager getInstance() {
        if (instance == null) {
            synchronized (LoggerManager.class) {
                if (instance == null) {
                    instance = new LoggerManager();
                }
            }
        }
        return instance;
    }

    private synchronized void initDefaultLogger() {
        if (defaultLogger == null) {
            defaultLogger = new DefaultLogger();
        }
    }

    public ILog getDefaultLogger() {
        return defaultLogger;
    }

    public ILog getCustomLogger() {
        return customLogger;
    }

    public void setCustomLogger(ILog customLogger) {
        this.customLogger = customLogger;
    }

    public ILog getLogger() {
        if (defaultLogger == null && customLogger == null) {
            Log.e("tag", "error occurred when initiating default logger.");
            ILog logger = defaultLogger = new DefaultLogger();
            return logger;
        }
        return customLogger == null ? defaultLogger : customLogger;
    }

}