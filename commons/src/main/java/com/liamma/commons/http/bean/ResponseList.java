package com.liamma.commons.http.bean;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/15 10:09
 * DESCRIPTION: Response 实体 list。
 */
public class ResponseList<T> extends AbstractResponse {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean isNull() {
        return this.data == null;
    }

    @NonNull
    @Override
    public String toString() {
        return "ResponseList{" +
                "code=" + getCode() +
                ", msg=" + getMsg() +
                ", data=" + data +
                '}';
    }

}
