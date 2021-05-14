package com.liamma.collections;

import android.content.Intent;
import android.widget.Button;

import com.liamma.collections.main.ui.TestingActivity;
import com.liamma.commons.frameworks.mvp.BaseToolsActivity;

public class MainActivity extends BaseToolsActivity {

    private static final String TAG = "MainActivity";

    private Button btnBigDecimal;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void initView() {
        btnBigDecimal = findViewById(R.id.btnBigDecimal);
    }

    @Override
    protected void initClick() {
        btnBigDecimal.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TestingActivity.class)));
    }

}
