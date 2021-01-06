package com.liamma.commons.log;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/6 14:27
 * DESCRIPTION: Base interface for all logger. This interface providers all methods when writing a log.
 */
public interface ILog {

    void i(String tag, String message);

    void d(String tag, String message);

    void v(String tag, String message);

    void w(String tag, String message);

    void e(String tag, String message);

    void f(String tag, String message);

}
