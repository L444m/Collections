package com.liamma.commons.image;

import android.widget.ImageView;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2020/12/8 14:53
 * DESCRIPTION: 图片加载的相关操作的抽象接口。
 */
public interface IImageOperations {

    void displayImage(ImageView imageView, Object url);

    void displayImage(ImageView imageView, Object url, int placeholder, int error);

    void displayRoundImage(ImageView imageView, Object url);

    void displayRoundImage(ImageView imageView, Object url, int placeholder, int error);

    void displayCircleImage(ImageView imageView, Object url);

    void displayCircleImage(ImageView imageView, Object url, int placeholder, int error);

    void displayGif(ImageView imageView, Object url);

    void displayGif(ImageView imageView, Object url, int placeholder, int error);

}
