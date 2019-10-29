package com.liamma.commons.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liamma.commons.ActivitiesManager;
import com.liamma.commons.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Base activity.
 * Created by Liam on 2018/07/12.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected String tag;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(" ---> onCreate");

        ActivitiesManager.getInstance().addActivity(this);

        // other works.
        initContentView();
        unbinder = ButterKnife.bind(this);

        // 执行业务相关。
        doBusiness();
    }

    /**
     * 留给子类去实现。
     */
    protected abstract void initContentView();

    protected abstract void doBusiness();

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(" ---> onStart");
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(" ---> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(" ---> onPause");
    }

    @Override
    protected void onStop() {
        LogUtils.i(" ---> onStop");
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(" ---> onDestroy");

        ActivitiesManager.getInstance().finishActivity(this);
        unbinder.unbind();
    }

}
