package com.liamma.commons.image;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2020/12/8 15:07
 * DESCRIPTION: 图片加载 provider 的抽象接口类。
 */
public interface IImageProvider extends IImageOperations {

    String getName();

    void clearMemoryCache();

    void clearDiskCache();

    void clearAll();

}
