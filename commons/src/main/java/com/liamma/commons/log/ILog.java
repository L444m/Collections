package com.liamma.commons.log;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/6 14:27
 * DESCRIPTION: Base interface for all logger. This interface providers all methods when writing a log.
 */
public interface ILog {

    /**
     * Log level : Verbose.
     */
    void v(String tag, String log);

    void v(String tag, String log, Throwable tr);

    /**
     * Log level : Debug.
     */
    void d(String tag, String log);

    void d(String tag, String log, Throwable tr);

    /**
     * Log level : Info.
     */
    void i(String tag, String log);

    void i(String tag, String log, Throwable tr);

    /**
     * Log level : Warning.
     */
    void w(String tag, String log);

    void w(String tag, String log, Throwable tr);

    /**
     * Log level : Error.
     */
    void e(String tag, String log);

    void e(String tag, String log, Throwable tr);

    /**
     * Log level : Asset.
     */
    void wtf(String tag, String log);

    void wtf(String tag, String log, Throwable tr);

}
