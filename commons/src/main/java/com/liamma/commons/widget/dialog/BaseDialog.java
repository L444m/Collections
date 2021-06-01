package com.liamma.commons.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
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

    private int layoutId;
    // cancelable
    private boolean cancel = true;
    // canceled on touch outside.
    private boolean cancelOutside = false;

    private int paddingLeft = 0;
    private int paddingTop = 0;
    private int paddingRight = 0;
    private int paddingBottom = 0;
    private int marginLeft = 0;
    private int marginRight = 0;
    private int marginTop = 0;
    private int marginBottom = 0;
    private int gravity = Gravity.CENTER;

    protected OnDialogClickListener onDialogClickListener;
    protected OnDismissListener onDismissListener;

    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        this.dialog = this;

        dialog.setContentView(getLayoutId());
        dialog.setCancelable(cancel);
        dialog.setCanceledOnTouchOutside(cancelOutside);
        //dialog.show();
        try {
            Window window = dialog.getWindow();
            window.getDecorView().setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = this.gravity;
            window.setAttributes(lp);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
    }

    /**
     * Offer a layout for this dialog.
     *
     * @return layout ResId
     */
    @LayoutRes
    protected abstract int getLayoutId();

    protected void initView() {
    }

    public BaseDialog setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
        return this;
    }

    public BaseDialog setMargin(int marginLeft, int marginRight, int marginTop, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        return this;
    }

    public BaseDialog setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public BaseDialog setCancel(boolean cancel) {
        this.cancel = cancel;
        return this;
    }

    public BaseDialog setCancelOutside(boolean cancelOutside) {
        this.cancelOutside = cancelOutside;
        return this;
    }

    public void showDialog() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
            context = null;
        }
    }

}
