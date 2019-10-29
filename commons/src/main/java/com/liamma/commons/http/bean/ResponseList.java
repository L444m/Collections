package com.liamma.commons.http.bean;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * Response 实体 list。
 * Created by Liam on 2018/7/15.
 */
public class ResponseList<T> extends AbstractResponse {

    // add paging data here.

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
