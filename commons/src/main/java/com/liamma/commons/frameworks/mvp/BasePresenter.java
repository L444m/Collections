package com.liamma.commons.frameworks.mvp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.log.LogUtils;

import java.lang.ref.WeakReference;

/**
 * Base abstract class presenter.
 * Created by Liam on 2018/11/14
 */
public abstract class BasePresenter<V extends BaseView> implements IPresenter<V> {

    // Uses weak reference to avoid memory leak.
    private WeakReference<V> viewRef = null;

    public BasePresenter() {
    }

    /**
     * 使用 view 带参数构造 BasePresenter.
     * 但是尽量不传递 view 构造，调用 {@code attachView(V view)} 绑定 view .
     *
     * @param view V
     */
    public BasePresenter(V view) {
        this.viewRef = new WeakReference<>(view);
    }

    @Nullable
    protected V getView() {
        V v = viewRef.get();
        if (v == null) {
            LogUtils.e("view == null. View is not attached now.");
        }
        return v;
    }

    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void attachView(@NonNull V view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void start() {
        // Prepare something before attaching view.
    }

}
