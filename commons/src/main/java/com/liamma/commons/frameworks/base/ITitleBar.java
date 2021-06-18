package com.liamma.commons.frameworks.base;

import androidx.annotation.ColorRes;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/18 11:39
 * DESCRIPTION: Operations for title bar.
 */
public interface ITitleBar {

    /**
     * default: show.
     */
    void showTitleBar(boolean show);

    void setTitleBarBg(@ColorRes int resColor);

    void setTitleBarBg(String strColor);

}
