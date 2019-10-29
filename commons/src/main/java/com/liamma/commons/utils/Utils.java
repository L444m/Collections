package com.liamma.commons.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utils.
 * Created by Liam on 2018/4/12.
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static <T> List<T> addToList(T... a) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, a);
        return list;
    }

    public static void test() {

    }

}
