package com.liamma.commons.widget;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;

/**
 * Base dialog.
 * Created by Liam on 2018/8/28.
 */
public abstract class BaseDialog extends Dialog {

    protected Context context;
    protected Dialog dialog;

    // resource layout of this dialog.
    protected int layoutId;
    protected boolean cancelable;
    protected boolean cancelOnTouchOutside;

    protected OnDialogClick onDialogClick;
    protected OnDismissListener onDismissListener;

    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    /**
     * Offer a layout for this dialog.
     * @return layout ResId
     */
    protected int setView() {
        return 0;
    }

    protected void initView(){
    }

    /**
     * A listener for
     */
    public interface OnDialogClick {

        void onPositiveButtonClick(Dialog dialog);

        void onNegativeButtonClick(Dialog dialog);

    }


}
