package com.liamma.commons.http.bean;

/**
 * Abstract Response。有 response 的基本结构，不能直接使用，需要子类继承。
 * Created by Liam on 2018/7/15.
 */
public abstract class AbstractResponse implements IResponse {

    public static final int DEFAULT_CODE_SUCCESS = 0;
    public static final String DEFAULT_MSG_SUCCESS = "OK";

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean isSuccess() {
        return code == DEFAULT_CODE_SUCCESS;
    }

    @Override
    public boolean isAuthError() {
        // 需要根据项目中具体定义的状态码来做判定。
        return false;
    }

    @Override
    public boolean isBizError() {
        // 需要根据项目中具体定义的状态码来做判定。
        return false;
    }

    @Override
    public int getStatusCode() {
        return code;
    }

    @Override
    public String getStatusMsg() {
        return msg;
    }

}
