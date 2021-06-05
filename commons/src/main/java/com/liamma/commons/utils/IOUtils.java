package com.liamma.commons.utils;

import androidx.annotation.Nullable;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/4/17 15:50
 * DESCRIPTION: I/O Utils.
 */
public final class IOUtils {

    private IOUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Closes the IO streams.
     */
    public static void close(@Nullable final Closeable... closeables) {
        if (EmptyUtils.isEmpty(closeables)) {
            return;
        }
        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                //ignore
            }
        }
    }

    /**
     * Closes the IO steam quietly.
     */
    public static void closeQuietly(@Nullable final Closeable... closeables) {
        if (EmptyUtils.isEmpty(closeables)) {
            return;
        }
        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                //swallow
            }
        }
    }

}
