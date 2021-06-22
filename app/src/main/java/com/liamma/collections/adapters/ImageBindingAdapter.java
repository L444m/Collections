package com.liamma.collections.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;

import com.liamma.commons.log.LogUtils;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/22 16:20
 * DESCRIPTION:
 */
public class ImageBindingAdapter {

    @BindingAdapter({"url"})
    public static void loadImage(ImageView imageView, String url) {
        LogUtils.i("load image url = " + url);
    }

    @BindingConversion
    public static String conversionString(String s) {
        return s + "_conn";
    }
}
