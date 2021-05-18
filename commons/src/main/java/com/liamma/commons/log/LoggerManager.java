package com.liamma.commons.log;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.utils.EmptyUtils;

import java.util.HashMap;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/17 14:04
 * DESCRIPTION:
 */
public final class LoggerManager {

    private static final String TAG = "LoggerManager";

    private static volatile LoggerManager instance = null;
    private HashMap<String, ILog> loggers;
    private ILog defaultLogger;

    private LoggerManager() {
        if (loggers == null) {
            loggers = new HashMap<>();
        } else {
            loggers.clear();
        }
        if (defaultLogger == null) {
            defaultLogger = new DefaultLogger();
            // Puts default logger in loggers array.
            loggers.put(defaultLogger.getClass().getSimpleName(), defaultLogger);
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

    /**
     * Recreates a new DefaultLogger instance if error occurs when initiating this class.
     */
    private void checkDefaultLoggerNotNull() {
        if (defaultLogger == null) {
            synchronized (this) {
                if (defaultLogger == null) {
                    Log.e(TAG, "Default logger is null.");
                    defaultLogger = new DefaultLogger();
                }
            }
        }
    }

    private void checkLoggersNotNull() {
        if (loggers == null) {
            loggers = new HashMap<>();
        }
    }

    public void addLogger(@Nullable Class<? extends ILog> clazz) {
        if (clazz == null) {
            Log.e(TAG, "Argument clazz is null.");
            return;
        }
        ILog logger = null;
        try {
            logger = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        addLogger(null, logger);
    }

    public void addLogger(@Nullable ILog logger) {
        addLogger(null, logger);
    }

    public void addLogger(@Nullable String loggerName, @Nullable ILog logger) {
        if (logger == null) {
            Log.e(TAG, "Logger is null, cannot put it in loggers array.");
            return;
        }
        if (EmptyUtils.isEmpty(loggerName)) {
            Log.e(TAG, "Logger name is empty, use logger's class name instead.");
            loggerName = logger.getClass().getSimpleName();
        }
        loggers.put(loggerName, logger);
    }

    public void setDefaultLogger(@Nullable ILog logger) {
        if (logger == null) {
            Log.e(TAG, "Default logger is null.");
            return;
        }
        this.defaultLogger = logger;
        this.loggers.put(logger.getClass().getSimpleName(), logger);
    }

    public void setDefaultLogger(@Nullable Class<? extends ILog> clazz) {
        if (clazz == null) {
            Log.e(TAG, "Argument clazz is null.");
            return;
        }
        ILog logger = null;
        try {
            logger = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultLogger(logger);
    }

    /**
     * Gets the default logger which should not be null and has been instantiated already.
     *
     * @return ILog Default logger
     */
    @NonNull
    public ILog getDefaultLogger() {
        checkDefaultLoggerNotNull();
        return defaultLogger;
    }

    /**
     * Gets the customized loggers. If user has not set any customized logger, an empty list would returned.
     *
     * @return ILog Customized logger
     */
    @NonNull
    public HashMap<String, ILog> getLoggers() {
        checkLoggersNotNull();
        return loggers;
    }

    /**
     * return the first custom logger.
     */
    /*public ILog getCustomLogger() {
        checkLoggersNotNull();
        if (EmptyUtils.isNotEmpty(customLoggers)) {
            return customLoggers.get(0);
        } else {
            return null;
        }
    }*/

    /*public ILog getCustomLogger(final Class<? extends ILog> clazz) {
        checkLoggersNotNull();
        if (clazz == null) {
            return getCustomLogger();
        }
        if (EmptyUtils.isNotEmpty(customLoggers)) {
            for (ILog logger : customLoggers) {
                if (clazz.equals(logger.getClass())) {
                    return logger;
                }
            }
        }
        return getCustomLogger();
    }*/
    public ILog getLogger() {
        // Gets default logger.
        return getDefaultLogger();
    }

    public ILog getLogger(final Class<? extends ILog> clazz) {
        String loggerName = clazz.getSimpleName();
        checkLoggersNotNull();
        ILog logger = loggers.get(loggerName);
        if (logger != null) {
            return logger;
        }
        addLogger(clazz);
        logger = loggers.get(loggerName);
        return logger;
    }

}
