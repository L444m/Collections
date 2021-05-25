package com.liamma.commons.widget.dialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/8/28 16:33
 * DESCRIPTION:
 */
public abstract class BaseDialog extends Dialog {

    protected Context context;
    protected Dialog dialog;

    // resource layout of this dialog.
    protected int layoutId;
    protected boolean cancelable;
    protected boolean cancelOnTouchOutside;

    protected OnDialogClickListener onDialogClickListener;
    protected OnDismissListener onDismissListener;

    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    /**
     * Offer a layout for this dialog.
     *
     * @return layout ResId
     */
    protected int setView() {
        return 0;
    }

    protected void initView() {
    }

}
