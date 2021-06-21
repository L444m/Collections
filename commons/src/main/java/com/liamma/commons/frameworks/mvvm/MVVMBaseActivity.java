package com.liamma.commons.frameworks.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.CheckResult;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.liamma.commons.BR;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 13:51
 * DESCRIPTION:
 */
public abstract class MVVMBaseActivity<B extends ViewDataBinding>
        extends AppCompatActivity
        implements View.OnClickListener {

    private B dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        if (dataBinding != null) {
            dataBinding.setLifecycleOwner(this);
            dataBinding.setVariable(BR.onClickListener, this);
            dataBinding.setVariable(BR.viewData, getViewData());
        }
    }

    @CheckResult
    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract Object getViewData();
}
