package com.liamma.collections.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.liamma.collections.BR;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 9:50
 * DESCRIPTION:
 */
public class User extends BaseObservable {

    private String name;
    private String password;
    private String id;

    public User(String name, String password, String id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // 刷新所有属性
        notifyChange();
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
