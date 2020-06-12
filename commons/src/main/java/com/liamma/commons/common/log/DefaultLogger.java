package com.liamma.commons.common.log;

import android.util.Log;

public class DefaultLogger implements ILog {

    @Override
    public void i(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    public void d(String tag, String message) {

    }

    @Override
    public void v(String tag, String message) {

    }

    @Override
    public void f(String tag, String message) {

    }
}
