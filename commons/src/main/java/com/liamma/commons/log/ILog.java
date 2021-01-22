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
     * @param tag
     * @param msg
     */
    void v(String tag, String msg);

    void v(String tag, String msg, Throwable tr);

    /**
     * Log level : Debug.
     * @param tag
     * @param msg
     */
    void d(String tag, String msg);

    void d(String tag, String msg, Throwable tr);

    /**
     * Log level : Info.
     * @param tag
     * @param msg
     */
    void i(String tag, String msg);

    void i(String tag, String msg, Throwable tr);

    /**
     * Log level : Warning.
     * @param tag
     * @param msg
     */
    void w(String tag, String msg);

    void w(String tag, String msg, Throwable tr);

    /**
     * Log level : Error.
     * @param tag
     * @param msg
     */
    void e(String tag, String msg);

    void e(String tag, String msg, Throwable tr);

    /**
     * Log level : Asset.
     * @param tag
     * @param msg
     */
    void wtf(String tag, String msg);

    void wtf(String tag, String msg, Throwable tr);

}
