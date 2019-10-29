package com.liamma.commons.http.observer;

import android.app.ProgressDialog;
import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 用于处理 response .
 * 和 BaseObserver 的区别在于：BaserObserverOriginal 没有对返回数据进行转换。
 * Created by Liam on 2018/7/19.
 */
public class BaseObserverOriginal<T> implements Observer<T> {

    private Context context;
    private ProgressDialog progressDialog;
    private Disposable disposable;

    public BaseObserverOriginal(Context context) {
        this.context = context.getApplicationContext();
    }

    public BaseObserverOriginal(Context context, boolean showDialog) {
        this.context = context.getApplicationContext();
        if (showDialog) {
            progressDialog = new ProgressDialog(this.context);
            progressDialog.setOnCancelListener(dialogInterface -> disposable.dispose());
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

}
