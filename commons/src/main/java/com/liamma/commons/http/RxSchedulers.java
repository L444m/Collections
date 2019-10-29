package com.liamma.commons.http;

import android.app.ProgressDialog;
import android.content.Context;

import com.liamma.commons.utils.LogUtils;
import com.liamma.commons.utils.NetworkUtils;
import com.liamma.commons.utils.ToastUtils;

import java.lang.ref.WeakReference;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Liam on 2018/7/19.
 */
public class RxSchedulers {

    /**
     * RxJava 中的线程切换 compose 。带有泛型参数。
     */
    public static <T> ObservableTransformer<T, T> ioMain() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    /**
     * RxJava 中的线程切换 compose 。没有泛型参数。
     */
    public static ObservableTransformer ioMain2() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 将 RxJava 中常用的操作符封装在一起，方便调用。
     */
    public static <T> ObservableTransformer<T, T> compose(final Context context) {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((Consumer<Disposable>) disposable -> {
                    if (NetworkUtils.isConnected()) {
                        ToastUtils.showLong(context, "网络异常!");
                    }
                });
    }


    private static ProgressDialog progressDialog;

    /**
     * 将 RxJava 中常用的操作符封装在一起，甚至包括请求时显示的 ProgressDialog。
     */
    private static <T> ObservableTransformer<T, T> composeAll(final Context context,
                                                              final boolean showDialog) {
        // 使用 WeakReference 防止 activity 已经关闭，但是网络请求 hold 引用，
        // 造成内在泄露。
        final WeakReference<Context> weakReference = new WeakReference<>(context);

        return upstream -> {
            if (showDialog && progressDialog == null) {
                // init ProgressDialog.
                progressDialog = new ProgressDialog(weakReference.get());
                progressDialog.setCancelable(true);
                progressDialog.setMessage("加载中...");
            }

            return upstream
                    .subscribeOn(Schedulers.io())
                    .doOnSubscribe(disposable -> {
                        if (!NetworkUtils.isConnected()) {
                            disposable.dispose();
                            ToastUtils.showLong(weakReference.get(), "网络异常!");
                            return;
                        }

                        if (showDialog && progressDialog != null && !progressDialog.isShowing()) {
                            progressDialog.show();
                            progressDialog.setOnCancelListener(dialogInterface -> {
                                LogUtils.d("Dialog cancelled and interrupt network request.");
                                disposable.dispose();
                            });
                        }
                    })
                    .doFinally(() -> {
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread());
        };
    }

}
