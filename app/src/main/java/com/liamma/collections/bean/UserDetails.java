package com.liamma.collections.bean;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/6/21 10:45
 * DESCRIPTION:
 */
public class UserDetails {

    private String name;
    private String id;
    private String address;
    private String info;

    public UserDetails(String name, String id, String address, String info) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
