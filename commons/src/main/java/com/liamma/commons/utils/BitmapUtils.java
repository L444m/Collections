package com.liamma.commons.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * Utility methods for Bitmap.
 * Created by Liam on 2017/12/7.
 */
public final class BitmapUtils {

    private BitmapUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // File 2 bitmap
    // bitmap 2 file
    // bitmap 2 gallery

    public static byte[] bitmapToBytes(@Nullable Bitmap bitmap) {
        return null;
    }

    public static String bitmapToString(@Nullable Bitmap bitmap) {
        byte[] bytes = bitmapToBytes(bitmap);

        if (EmptyUtils.isEmpty(bytes)) {
            return "";
        } else {
            return new String(bytes);
        }
    }

    /**
     * Saves bitmap into the specified filename.
     *
     * @param bitmap   Bitmap
     * @param filename String filename
     * @return {@code true} if saving successfully, otherwise {@code false}.
     */
    public static File bitmapToFile(@NonNull Bitmap bitmap, String filename) {
        return null;
    }

    public static boolean bitmapToFile(@NonNull Bitmap bitmap, File file) {
        return false;
    }

    /**
     * Compresses image by pixel, this will modify width/height.
     * Used to get thumbnail.
     *
     * @param context Context
     * @param imgUri  Uri of specified image
     * @param wPixel  Target pixel of width
     * @param hPixel  Target pixel of height
     * @return Bitmap
     * @throws IOException IOException
     */
    public static Bitmap getRatioBitmap(Context context, Uri imgUri, int wPixel, int hPixel)
            throws IOException {

        BitmapFactory.Options boundsOptions = new BitmapFactory.Options();
        boundsOptions.inJustDecodeBounds = true;
        // default : Bitmap.Config.ARGB_8888
        boundsOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        InputStream inputStream = context.getContentResolver().openInputStream(imgUri);
        BitmapFactory.decodeStream(inputStream, null, boundsOptions);
        if (inputStream != null) inputStream.close();

        int w = boundsOptions.outWidth;
        int h = boundsOptions.outHeight;
        int scale = getScale(w, h, wPixel, hPixel);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        // options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = scale;
        inputStream = context.getContentResolver().openInputStream(imgUri);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        if (inputStream != null) inputStream.close();

        return bitmap;
    }

    public static Bitmap getRatioBitmap(String imgPath, float wPixel, float hPixel) {
        return null;
    }

    /**
     * Gets the compression ratio of this Bitmap.
     *
     * @param wOriginal Original width
     * @param hOriginal Original height
     * @param wTarget   Target width
     * @param hTarget   Target height
     * @return ratio
     */
    private static int getScale(int wOriginal, int hOriginal, int wTarget, int hTarget) {
        int scale = 1;
        if (wTarget >= wOriginal && hTarget >= hOriginal) return scale;

        int wRatio = (wOriginal % wTarget) == 0 ? wOriginal / wTarget : wOriginal / wTarget + 1;
        int hRatio = (hOriginal % hTarget) == 0 ? hOriginal / hTarget : hOriginal / hTarget + 1;

        scale = wRatio > hRatio ? wRatio : hRatio;
        return scale;
    }

}
