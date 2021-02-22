package com.liamma.commons.http.bean;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/15 00:00
 * DESCRIPTION: Interface for all Http response。
 */
public interface IResponse {

    /**
     * Whether the http request is successful or not.
     *
     * @return {@code true} means getting http response successfully, otherwise {@code false}.
     */
    boolean isSuccess();

    /**
     * Whether the http response is null or not.
     *
     * @return {@code true} means that http response is null, otherwise {@code false}。
     */
    boolean isNull();

    /**
     * Whether
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
