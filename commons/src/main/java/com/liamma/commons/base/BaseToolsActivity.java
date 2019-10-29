package com.liamma.commons.base;

import android.view.View;

/**
 * 封装带有基本功能，如 ToolsBar,Dialog,Toast 等的 Activity。
 * Created by Liam on 2018/07/12.
 */
public abstract class BaseToolsActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void initContentView() {

        // 另外处理 inflater 等。

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }

    }

    @Override
    protected void doBusiness() {
        // 处理 title / back / menu 等。

        // initView(); or initData();
        initView();
        initData();
    }

    /**
     * 返回当前需要使用的布局 resource Id.
     * @return resource Id.
     */
    protected abstract int getLayoutId();

    protected void initView() {

    }

    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

}
