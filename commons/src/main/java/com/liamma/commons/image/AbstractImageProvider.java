package com.liamma.commons.image;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2020/12/8 16:30
 * DESCRIPTION:
 */
public abstract class AbstractImageProvider implements IImageProvider {

    private String name;

    public AbstractImageProvider() {
        this.name = this.getClass().getSimpleName();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
