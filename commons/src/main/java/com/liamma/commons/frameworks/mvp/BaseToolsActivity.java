package com.liamma.commons.frameworks.mvp;

/**
 * 封装带有基本功能，如 ToolsBar,Dialog,Toast 等的 Activity。
 * Created by Liam on 2018/07/12.
 */
public abstract class BaseToolsActivity extends BaseActivity {

    @Override
    protected void initContentView() {
        super.initContentView();

        // 另外处理 inflater 等。
    }

}
