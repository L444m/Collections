package com.liamma.commons.frameworks.base;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.liamma.commons.R;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/15 15:42
 * DESCRIPTION:
 */
public abstract class BaseTitleRefreshActivity extends BaseTitleActivity implements ISwipeToRefresh {

    private SwipeRefreshLayout srlRefresh;

    @Override
    protected void initContentView() {
        validateLayoutId();
        setContentView(R.layout.common_activity_base_title_refresh);
        addLayoutView();
        initBaseView();
        initBaseListeners();
    }

    @Override
    protected void initBaseView() {
        super.initBaseView();
        srlRefresh = findViewById(R.id.srlRefresh);
    }

    public void enableRefresh(boolean enable) {
        if (!enable && srlRefresh.isRefreshing()) {
            srlRefresh.setRefreshing(false);
        }
        srlRefresh.setEnabled(false);
    }
}
