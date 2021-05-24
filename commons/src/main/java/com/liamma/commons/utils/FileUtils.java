package com.liamma.commons.utils;

import android.net.Uri;

import androidx.annotation.Nullable;

import java.io.File;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2017/12/6 15:39
 * DESCRIPTION: Utility methods of file.
 */
public final class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1024 * ONE_KB;
    public static final long ONE_GB = 1024 * ONE_MB;
    public static final long ONE_TB = 1024 * ONE_GB;

    @Nullable
    public static File getFile(@Nullable String filePath) {
        if (filePath == null) {
            return null;
        }
        File file = new File(filePath);
        if (!file.exists()) {

        }
        return null;
    }

    @Nullable
    public static File getFile(@Nullable Uri uri) {
        return null;
    }

    @Nullable
    public static File getFile(@Nullable String directory, @Nullable String filename) {
        return null;
    }

}
