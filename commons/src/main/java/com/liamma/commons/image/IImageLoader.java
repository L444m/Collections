package com.liamma.commons.image;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/2/25 13:25
 * DESCRIPTION:
 */
public interface IImageLoader extends IImageOperations {

    void addProvider(IImageProvider provider);

    void addProvider(String key, IImageProvider provider);

    IImageProvider getProvider(String key);

    void setCurrentProvider(String key);

    void setCurrentProvider(IImageProvider provider);

    IImageProvider getCurrentProvider();

    IImageProvider getDefaultProvider();

    void removeProvider(String key);

    void removeAll();

}
