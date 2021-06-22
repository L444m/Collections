package com.liamma.commons.frameworks.mvvm.bdadapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/22 17:14
 * DESCRIPTION:
 */
public final class ImageBindingAdapter {

    @BindingAdapter(value = {"imageUrl", "placeholder"}, requireAll = false)
    public static void loadImage(ImageView imageView, String imageUrl, String placeholder) {

    }
}
