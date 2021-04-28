package com.liamma.collections;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.liamma.collections.main.ui.AnimatorActivity;
import com.liamma.commons.frameworks.mvp.BaseToolsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseToolsActivity {

    private static final String TAG = "MainActivity";

    private TextView tvMainInfo;
    private TextView tvStartAnimator;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void initView() {
        tvMainInfo = findViewById(R.id.tvMainInfo);
        tvStartAnimator = findViewById(R.id.tvMainStartAnimator);
        tvStartAnimator.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AnimatorActivity.class)));
    }

    private void copyToClipBoard(String content) {
        ClipboardManager cbm = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        if (cbm == null) return;
        cbm.setPrimaryClip(ClipData.newPlainText(null, content));
    }




}
