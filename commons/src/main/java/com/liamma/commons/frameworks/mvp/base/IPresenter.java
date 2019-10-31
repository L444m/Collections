package com.liamma.commons.frameworks.mvp.base;

/**
 * The root interface of Presenter layer.
 * Created by Liam on 2018/11/14
 */
public interface IPresenter<V> {

    void attachView(V view);

    void detachView();

    // Prepare for presenter before attaching view.
    void start();

}
