package com.liamma.commons.http.observer;

import android.app.ProgressDialog;
import android.content.Context;

import com.liamma.commons.http.bean.ResponseEntity;
import com.liamma.commons.utils.LogUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Base observer for deal with responses.
 * Created by Liam on 2018/7/19.
 */
public abstract class BaseObserver<T> implements Observer<ResponseEntity<T>> {

    private Context context;
    private ProgressDialog progressDialog;
    private Disposable disposable;

    // 不带进度条。
    public BaseObserver(Context context) {
        this.context = context.getApplicationContext();
    }

    // 带有进度条效果的。
    public BaseObserver(Context context, boolean showProgress) {
        this.context = context.getApplicationContext();
        if (showProgress) {
            progressDialog = new ProgressDialog(this.context);
            progressDialog.setOnCancelListener(dialogInterface -> disposable.dispose());
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(ResponseEntity<T> value) {
        if (value.getStatusCode() == 0) {
            onSuccess(value.getData());

        } else {
            if (value.isAuthError()) {
                LogUtils.d("is auth error.");
            } else if (value.isBizError()) {
                LogUtils.d("is biz error.");
            }

            // error process.
        }
    }

    @Override
    public void onError(Throwable e) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onComplete() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /**
     * response 正常返回时的处理。
     */
    public abstract void onSuccess(T t);

    /**
     * response 异常时的处理。
     * @param code   错误 code
     * @param errMsg 错误 message
     */
    public void onFailure(int code, String errMsg) {
    }

}
