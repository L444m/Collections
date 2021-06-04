package com.liamma.commons.data.cache;

import java.io.Serializable;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/13 16:47
 * DESCRIPTION:
 */
public class CacheObject<T extends Serializable> {

    private long create;
    private long expire = -1L;
    private boolean forever = false;
    private T data;

    public static <T extends Serializable> CacheObject<T> newInstance(T t) {
        return newInstance(t, false, -1L);
    }

    public static <T extends Serializable> CacheObject<T> newInstance(T t, boolean forever, long expire) {
        CacheObject<T> cacheObject = new CacheObject<>();
        cacheObject.setForever(forever);
        cacheObject.setExpire(expire);
        cacheObject.setData(t);
        return cacheObject;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public void setForever(boolean forever) {
        this.forever = forever;
    }

    public void setData(T data) {
        this.data = data;
        this.create = System.currentTimeMillis();
    }

    public long getCreate() {
        return create;
    }

    public long getExpire() {
        return expire;
    }

    public boolean isForever() {
        return forever;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CacheObject{" +
                "create=" + create +
                ", expire=" + expire +
                ", forever=" + forever +
                ", data=" + data +
                '}';
    }
}
