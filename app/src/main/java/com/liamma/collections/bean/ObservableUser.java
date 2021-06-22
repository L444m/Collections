package com.liamma.collections.bean;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 11:54
 * DESCRIPTION:
 */
public class ObservableUser {

    private ObservableField<String> name;
    private String password;
    private ObservableLong id;

    public ObservableUser(String name, String password, long id) {
        this.name = new ObservableField<String>(name);
        this.password = password;
        this.id = new ObservableLong(id);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ObservableLong getId() {
        return id;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id.set(id);
    }
}
