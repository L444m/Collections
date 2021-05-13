package com.liamma.commons.data.cache;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/13 16:47
 * DESCRIPTION:
 */
public class CacheObject<T> {

    private long create;
    private long expire;
    private boolean forever;
    private T data;

}
