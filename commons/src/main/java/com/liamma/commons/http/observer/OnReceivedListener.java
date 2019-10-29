package com.liamma.commons.http.observer;

/**
 * Listener for receiving response from server.
 * Created by Liam on 2019/10/29.
 */
public interface OnReceivedListener<T> {

    void onSuccess(T t);

    /**
     * @param status error status code
     * @param msg    error message
     */
    void onFailure(int status, String msg);

}
