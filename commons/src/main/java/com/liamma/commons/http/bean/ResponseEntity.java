package com.liamma.commons.http.bean;

import androidx.annotation.NonNull;

/**
 * Response 实体。
 * Created by Liam on 2018/7/15.
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
