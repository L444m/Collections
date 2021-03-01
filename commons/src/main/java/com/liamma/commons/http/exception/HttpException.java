package com.liamma.commons.http.exception;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/3/1 16:46
 * DESCRIPTION: Base exception for all exceptions in http requesting.
 */
public class HttpException extends Exception {

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }
}
