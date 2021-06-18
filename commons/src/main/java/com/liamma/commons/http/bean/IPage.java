package com.liamma.commons.http.bean;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/18 9:50
 * DESCRIPTION:
 */
public interface IPage {

    /**
     * Whether it's end for loading data.
     */
    boolean isEnd();

    /**
     * Returns the number of all pages.
     */
    int getTotalPage();

    /**
     * Returns the size of each page.
     */
    int getPageSize();

    /**
     * Returns index of current page.
     */
    int getPageIndex();

}
