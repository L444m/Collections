package com.liamma.commons.adapters.binding;

import android.view.View;

import androidx.databinding.BindingAdapter;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/23 16:40
 * DESCRIPTION:
 */
public class ViewAdapter {

    @BindingAdapter({"isGone"})
    public static void bindIsGone(View view, boolean isGone) {
        view.setVisibility(isGone ? View.GONE : View.VISIBLE);
    }
}
