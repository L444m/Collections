package com.liamma.commons.frameworks.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.CheckResult;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liamma.commons.ActivitiesManager;
import com.liamma.commons.common.StatusBarUtils;
import com.liamma.commons.utils.ClickUtils;
import com.liamma.commons.utils.KeyboardUtils;
import com.liamma.commons.utils.LogUtils;
import com.liamma.commons.utils.ToastUtils;
import com.liamma.commons.widget.dialog.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Base activity.
 * Created by Liam on 2018/07/12.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected static String TAG;

    protected Context context;
    @Nullable
    protected Bundle extras;
    protected Unbinder unbinder;
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // No Title at the top of screen.
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // TODO: set status bar color.
        StatusBarUtils.setBarColor(this);

        hideLoading();
        TAG = this.getClass().getSimpleName();
        LogUtils.d(" ---> onCreate");

        ActivitiesManager.getInstance().addActivity(this);

        prepare();
        initContentView();
        this.context = this;
        // ButterKnife initiation should be processed after setting content view.
        this.unbinder = ButterKnife.bind(this);
        this.extras = getIntent().getExtras();
        doBusiness();
    }

    /**
     * Do some work before init content view.
     */
    protected void prepare() {
    }

    /**
     * Initiates the UI, show content of Layout resource.
     */
    protected void initContentView() {
        if (getLayoutId() == 0) {
            throw new IllegalArgumentException("must set layout id in activity.");
        }

        setContentView(getLayoutId());
    }

    /**
     * Do some business work。
     */
    private void doBusiness() {
        initView();
        initClick();
        initData();
    }

    /**
     * Returns the layout resource Id.
     * Subclass which is not abstract **must** override it and provide a corresponding layout id.
     */
    @CheckResult
    @LayoutRes
    protected abstract int getLayoutId();

    protected void initView() {
    }

    protected void initClick() {
    }

    protected void initData() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(" ---> onStart");
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(" ---> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d(" ---> onPause");
    }

    @Override
    protected void onStop() {
        LogUtils.d(" ---> onStop");
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtils.d(" ---> onDestroy");

        unbinder.unbind();
        ActivitiesManager.getInstance().finishActivity(this);

        super.onDestroy();
    }

    protected void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        loadingDialog.showDialog();
    }

    protected void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismissDialog();
            loadingDialog = null;
        }
    }

    /**
     * 处理点击事件。
     * 子类如果重写本方法处理点击事件，则为 非安全 ，没有处理“快速点击”。
     *
     * @param v View
     */
    @Override
    public void onClick(View v) {
        if (ClickUtils.isValid(v)) {
            onSafeClick(v);
        }
    }

    /**
     * 处理点击事件。
     * 子类如果生写本方法处理点击事件，则为 安全，已经过滤了“快速点击”。
     *
     * @param v View
     */
    protected void onSafeClick(View v) {
    }

    protected void quickStartActivity(@NonNull Intent intent) {
        startActivity(intent);
    }

    protected void quickStartActivity(@NonNull Class clazz, @Nullable Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void quickStartActivity(@NonNull Class clazz) {
        quickStartActivity(clazz, null);
    }

    protected void showToastLong(String message) {
        ToastUtils.showLong(this, message);
    }

    protected void showToastShort(String message) {
        ToastUtils.showShort(this, message);
    }

    protected void hideSoftKeyboard(View v) {
        KeyboardUtils.hideSoftKeyboard(this);
    }

}
