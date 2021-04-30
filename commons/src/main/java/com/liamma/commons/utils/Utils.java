package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/4/12 16:43
 * DESCRIPTION: Utility methods.
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    /**
     * Converts elements array to List.
     */
    @NonNull
    public static <T> List<T> toList(@Nullable T... array) {
        List<T> list = new ArrayList<>();
        if (EmptyUtils.isEmpty(array)) {
            return list;
        }
        Collections.addAll(list, array);
        return list;
    }


}
