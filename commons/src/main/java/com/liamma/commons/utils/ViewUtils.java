package com.liamma.commons.utils;

import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/2/22 11:50
 * DESCRIPTION:
 */
public final class ViewUtils {

    private ViewUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    public static String getText(@NonNull TextView textView) {
        CharSequence charSequence = textView.getText();
        return charSequence == null ? "" : charSequence.toString();
    }

    public static String getTrimmedText(@NonNull TextView textView) {
        CharSequence charSequence = textView.getText();
        return charSequence == null ? "" : charSequence.toString().trim();
    }

    public static boolean isEditNotEmpty(@NonNull EditText editText, String toast) {
        if (EmptyUtils.isEmpty(editText.getText())) {
            ToastUtils.showShort(editText.getContext(), toast);
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEditNotEmpty(@NonNull EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (EmptyUtils.isEmpty(editText.getText())) {
                 return false;
            }
        }
        return true;
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
