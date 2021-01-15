package com.liamma.commons.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.liamma.commons.R;

/**
 * Loading dialog.
 * Created by Liam on 2019/10/31.
 */
public class LoadingDialog extends Dialog {

    private Context context;
    private LoadingDialog dialog;

    public LoadingDialog(@NonNull Context context) {
        super(context, 0);
        this.context = context;
        dialog = this;

        dialog.setContentView(R.layout.common_dialog_loading);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        //dialog.show();

        try {
            Window window = dialog.getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);

            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = Gravity.CENTER;
            window.setAttributes(lp);
            window.setBackgroundDrawableResource(android.R.color.transparent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDialog() {
        dialog.show();
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
            context = null;
        }
    }

}
