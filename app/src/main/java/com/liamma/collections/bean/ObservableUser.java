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
    private ObservableField<String> password;
    private ObservableLong id;

    public ObservableUser(String name, String password, long id) {
        this.name = new ObservableField<String>(name);
        this.password = new ObservableField<String>(password);
        this.id = new ObservableLong(id);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(ObservableField<String> password) {
        this.password = password;
    }

    public ObservableLong getId() {
        return id;
    }

    public void setId(ObservableLong id) {
        this.id = id;
    }
}
