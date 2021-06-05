package com.liamma.commons.utils;

import com.liamma.commons.log.LogUtils;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/15 14:48
 * DESCRIPTION:
 */
public final class PreCheck {

    private PreCheck() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static <T> T checkNotNull(T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

    public static boolean isNull(Object value) {
        if (value == null) {
            LogUtils.e("The checking object is null.");
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(Object value, String message) {
        if (value == null) {
            LogUtils.e(message);
            return true;
        } else {
            return false;
        }
    }
}
