package com.liamma.commons.http.bean;

import androidx.annotation.NonNull;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/15 10:08
 * DESCRIPTION: Response 实体。
 */
public class ResponseEntity<T> extends AbstractResponse {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean isNull() {
        return data == null;
    }

    @NonNull
    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + getCode() +
                ", msg=" + getMsg() +
                ", data=" + data +
                '}';
    }

}
