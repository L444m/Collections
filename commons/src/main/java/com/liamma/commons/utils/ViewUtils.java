package com.liamma.commons.utils;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/2/22 11:50
 * DESCRIPTION:
 */
public final class ViewUtils {

    private ViewUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String getText(@NonNull TextView textView) {
        return StringUtils.nullToEmpty(textView.getText());
    }

    public static String getTrimmedText(@NonNull TextView textView) {
        return StringUtils.nullToEmpty(textView.getText()).trim();
    }

    /**
     * Supports {@link Button}, {@link EditText} also.
     */
    public static boolean isEmpty(@Nullable String toast, @NonNull TextView textView) {
        if (EmptyUtils.isEmpty(textView.getText())) {
            if (EmptyUtils.isNotEmpty(toast)) {
                // show warning toast message.
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Supports {@link Button}, {@link EditText} also.
     * Checks multiple TextView and show same toast message only once.
     */
    public static boolean isEmpty(@Nullable String toast, @NonNull TextView... textViews) {
        for (TextView textView : textViews) {
            if (EmptyUtils.isEmpty(textView.getText())) {
                if (EmptyUtils.isNotEmpty(toast)) {
                    // show warning toast message.
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isEditLengthValid(@NonNull EditText editText, int min, int max, String toast) {
        Editable editable = editText.getText();
        int length = editable == null ? 0 : editable.length();
        if (min > 0) {
            // means that need to check the minimal length of the specified EditText.
            if (length < min) {
                ToastUtils.showShort(editText.getContext(), toast);
                return false;
            }
        }
        if (max > 0) {
            // means that need to check the max length of the specified EditText.
            if (length > max) {
                ToastUtils.showShort(editText.getContext(), toast);
                return false;
            }
        }
        return true;
    }


}
