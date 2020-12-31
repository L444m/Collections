package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * Utility methods for operating of stream.
 * Created by Liam on 2017/12/6.
 */
public final class StreamUtils {

    private StreamUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Reads bytes from an InputStream.
     *
     * @param inputStream InputStream
     * @return Byte array
     * @throws IOException IOException
     */
    public static byte[] readBytes(@NonNull InputStream inputStream) throws IOException {
        // TODO: 注解和参数校验，应该如何取舍？
        // Objects.requireNonNull(in, "InputStream is null");

        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            bis = new BufferedInputStream(inputStream);
            baos = new ByteArrayOutputStream();

            // Set buffer 4K.
            byte[] buffer = new byte[4096];
            int length;
            while ((length = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            baos.flush();
            return baos.toByteArray();

        } finally {
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(baos);
        }
    }

    public static String readString(@NonNull InputStream inputStream) throws IOException {
        return new String(readBytes(inputStream));
    }

    /**
     * Writes bytes into an OutputStream.
     *
     * @param out   OutputStream
     * @param bytes Byte array
     * @return {@code true} if writing successfully, otherwise {@code false}.
     * @throws IOException IOException
     */
    public static boolean write(@NonNull OutputStream out, @Nullable byte[] bytes) throws IOException {
        Objects.requireNonNull(out, "OutputStream is null");
        if (EmptyUtils.isEmpty(bytes)) {
            return true;
        }

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(out);
            // FIXME: 2016/10/24
            // If the size of bytes is extremely large, it may produce memory
            // over used problem.
            bos.write(bytes);
            bos.flush();
            return true;
        } finally {
            IOUtils.closeQuietly(bos);
        }
    }

    public static boolean copy(InputStream in, OutputStream out) {
        return false;
    }

}
