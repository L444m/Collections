package com.liamma.commons.utils;

import java.io.Closeable;
import java.io.IOException;


/**
 * I/O Utils.
 * Created by Liam on 2018/4/17.
 */
public final class IOUtils {

    private IOUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Closes the IO streams.
     */
    public static void close(final Closeable... closeables) {
        if (EmptyUtils.isEmpty(closeables)) return;

        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Closes the IO steam quietly.
     */
    public static void closeQuietly(final Closeable... closeables) {
        if (EmptyUtils.isEmpty(closeables)) return;

        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                // swallow
                // e.printStackTrace();
            }
        }
    }

}
