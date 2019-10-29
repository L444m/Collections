package com.liamma.collections.statusmode;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.liamma.collections.R;
import com.liamma.commons.common.StatusBarUtils;


/**
 * 沉浸式状态栏。
 */
public class StatusMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_mode);

        // 隐藏 ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        // 全屏显示 （隐藏 status bar 和 navigator）
//        View decorView = getWindow().getDecorView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);

        // 设置状态颜色为透明
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        StatusBarUtils.setBarColor(this);

    }

}
