package com.liamma.commons.widget.dialog;

import android.app.Dialog;
import android.os.Parcelable;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/25 16:54
 * DESCRIPTION:
 */
public interface OnDialogClickListener<T extends Parcelable> {

    void onPositiveButtonClick(Dialog dialog);

    void onNegativeButtonClick(Dialog dialog);
}
