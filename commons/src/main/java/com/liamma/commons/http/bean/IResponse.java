package com.liamma.commons.http.bean;

/**
 * Interface of Http Response，所有 response bean 对象的基础。
 * Created by Liam on 2018/7/15.
 */
public interface IResponse {

    /**
     * 请求是否成功。
     *
     * @return {@code true} response 成功。
     */
    boolean isSuccess();

    /**
     * 是否是 null 数据。
     *
     * @return {@code true} 返回的数据为 null。
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
     * @return 返回状态码。
     */
    int getStatusCode();

    /**
     * @return 返回状态消息。
     */
    String getStatusMsg();

}
