package com.liamma.commons.events;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/5/18 11:48
 * DESCRIPTION: Common message event.
 */
public class CommonMessageEvent {

    private String type;
    private Object data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
