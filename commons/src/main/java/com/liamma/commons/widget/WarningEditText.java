package com.liamma.commons.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/1/22 16:11
 * DESCRIPTION: An EditText tha can show a warning content below if the input is not match.
 */
public class WarningEditText extends ViewGroup {

    /*
     * +----------------------+
     * |                      |
     * | Input area      icon |
     * +----------------------+
     *   Warning content
     */

    private Context context;
    private AppCompatEditText etEdit;
    private TextView tvWarningText;

    public WarningEditText(@NonNull Context context) {
        super(context);
        this.context = context;
        initView();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private void initView() {
        etEdit = new AppCompatEditText(context);
        LayoutParams editLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        tvWarningText = new TextView(context);
    }


}
