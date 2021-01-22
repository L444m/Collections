package com.liamma.commons.log;

import android.util.Log;

import com.liamma.commons.utils.EmptyUtils;

import java.util.ArrayList;
import java.util.HashMap;

public final class LoggerManager {

    private static final String TAG = "LoggerManager";

    private static volatile LoggerManager instance = null;
    private ILog defaultLogger;
    private ILog customLogger;
    private HashMap<String, ILog> loggers;
    private ArrayList<ILog> customLoggers;

    private LoggerManager() {
        if (defaultLogger == null) {
            defaultLogger = new DefaultLogger();
        }
        if (customLoggers == null) {
            customLoggers = new ArrayList<>();
        } else {
            customLoggers.clear();
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

    private void checkCustomLoggersNotNull() {
        if (customLoggers == null) {
            customLoggers = new ArrayList<>();
        }
    }

    public void addCustomLogger(String loggerName, ILog logger) {

        if (loggerName == null) {
            loggers.put(loggerName, logger);
        }
    }

    public void setCustomLogger() {

    }

    /**
     * Gets the default logger which should not be null and has been instantiated already.
     *
     * @return ILog Default logger
     */
    public ILog getDefaultLogger() {
        if (defaultLogger == null) {
            Log.e(TAG, "defaultLogger == null, error occurred when instantiating LoggerManager.");
            initDefaultLogger();
        }
        return defaultLogger;
    }

    /**
     * Gets the customized loggers. If user has not set any customized logger, an empty list would returned.
     *
     * @return ILog Customized logger
     */
    public ArrayList<ILog> getCustomLoggers() {
        checkCustomLoggersNotNull();
        return customLoggers;
    }

    /**
     * return the first custom logger.
     */
    public ILog getCustomLogger() {
        checkCustomLoggersNotNull();
        if (EmptyUtils.isNotEmpty(customLoggers)) {
            return customLoggers.get(0);
        } else {
            return null;
        }
    }

    public ILog getCustomLogger(final Class<? extends ILog> clazz) {
        checkCustomLoggersNotNull();
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
    }

    public synchronized void addCustomLogger(int index, ILog logger) {
        checkCustomLoggersNotNull();
        customLoggers.add(index, logger);
    }

    public synchronized void addCustomLogger(ILog logger) {
        checkCustomLoggersNotNull();
        customLoggers.add(logger);
    }

    public ILog getLogger() {
        if (customLoggers != null) {
            return getCustomLogger();
        } else {
            // customLogger == null, means that user has not set a customized logger.
            return getDefaultLogger();
        }
    }

    public ILog getLogger(final Class<? extends ILog> clazz) {

        return null;
    }

}
