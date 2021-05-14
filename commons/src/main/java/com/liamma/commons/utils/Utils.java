package com.liamma.commons.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import com.liamma.commons.Commons;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/4/12 16:43
 * DESCRIPTION: Utility methods.
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    private static void copyToClipBoard(String content) {
        ClipboardManager cbm = (ClipboardManager) Commons.getApp().getSystemService(Context.CLIPBOARD_SERVICE);
        if (cbm == null) return;
        cbm.setPrimaryClip(ClipData.newPlainText(null, content));
    }

}
