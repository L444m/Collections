package com.liamma.collections;

import android.content.Intent;
import android.widget.Button;

import com.liamma.collections.main.ui.DataBindingActivity;
import com.liamma.commons.frameworks.base.BaseTitleActivity;

public class MainActivity extends BaseTitleActivity {

    private static final String TAG = "MainActivity";

    private Button btnNextPage;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void initView() {
        btnNextPage = findViewById(R.id.btnNextPage);
    }

    @Override
    protected void initListeners() {
        btnNextPage.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DataBindingActivity.class)));
    }

}
