package com.bdzt.springboot.example.test;

import java.io.Serializable;

/**
 * TODO:add description of class here, then delete the line.
 *
 * @author zhanghongbing
 * @version 17/10/14
 */
public class User implements Serializable {

    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "id:" + id + ";name:" + name + ";password:"+password;
    }
}
