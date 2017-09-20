package com.jason.serializable.object1;

import java.io.Serializable;

public class A implements Serializable {

    private static final long serialVersionUID = 1;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
