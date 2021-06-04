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
import com.liamma.commons.events.CommonMessageEvent;
import com.liamma.commons.log.LogUtils;
import com.liamma.commons.utils.ClickUtils;
import com.liamma.commons.utils.KeyboardUtils;
import com.liamma.commons.utils.ToastUtils;
import com.liamma.commons.widget.dialog.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/07/12 10:12
 * DESCRIPTION: Base activity.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected static String TAG = "";

    protected Context context;
    protected Unbinder unbinder;
    @Nullable
    protected Bundle extras;
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set status bar color, or set it in sub activity.
        //StatusBarUtils.setBarColor(this);
        ActivitiesManager.getInstance().add(this);
        hideLoading();

        TAG = this.getClass().getSimpleName();
        this.context = this;
        this.extras = getIntent().getExtras();
        LogUtils.d(" ---> onCreate");

        prepare();
        initContentView();
        // ButterKnife initiation should be processed after setting content view.
        this.unbinder = ButterKnife.bind(this);
        doBusiness();
    }

    /**
     * Preparations for Activity which should be done before initiating content view,
     * override this method in sub Activity.
     */
    protected void prepare() {
    }

    /**
     * Initiates the UI, show content of layout resource.
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
     * Subclass which is not abstract <>must</> override it and provide a corresponding layout id.
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
        if (unbinder != null) {
            unbinder.unbind();
        }
        ActivitiesManager.getInstance().finish(this);
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
     * Handles the click events.
     * It's "unsafe" to override this method in sub class to handle click events because this method
     * does not filter "double click".
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
     * Handles the click events.
     * It's "safe" to override this method in sub class to handle click event as this method has
     * filtered "double click".
     *
     * @param v View
     */
    protected void onSafeClick(View v) {
    }

    /**
     * Handles the received message event.
     *
     * @param messageEvent MessageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CommonMessageEvent messageEvent) {
    }

    protected void quickStartActivity(@NonNull Intent intent) {
        startActivity(intent);
    }

    protected void quickStartActivity(@NonNull Class<?> clazz, @Nullable Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void quickStartActivity(@NonNull Class<?> clazz) {
        quickStartActivity(clazz, null);
    }

    protected void showToastLong(String message) {
        ToastUtils.showLong(this, message);
    }

    protected void showToastShort(String message) {
        ToastUtils.showShort(this, message);
    }

    protected void hideKeyboard(View v) {
        KeyboardUtils.hideKeyboard(this);
    }

}
