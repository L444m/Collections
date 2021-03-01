package com.liamma.commons.http.bean;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/15 00:00
 * DESCRIPTION: Base interface class for all Http response。
 */
public interface IResponse {

    /**
     * Whether the http request is successful or not.
     */
    boolean isSuccess();

    /**
     * Whether the http response is null or not.
     */
    boolean isNull();

    /**
     * 是否是验证错误。
     *
     * @return {@code true} response 为验证错误。
     */
    boolean isAuthError();

    /**
     * 是否是业务错误。
     *
     * @return {@code true} response 为业务错误。
     */
    boolean isBizError();

    /**
     * @return status code。
     */
    int getStatusCode();

    /**
     * @return status message。
     */
    String getStatusMsg();

}
