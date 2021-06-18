package com.liamma.commons.http.bean;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/18 9:45
 * DESCRIPTION:
 */
public class ResponsePage<T> extends ResponseList<T> implements IPage {

    // Adds paging data here.

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public int getTotalPage() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public int getPageIndex() {
        return 0;
    }
}
