package com.jason.serializable.object2;

import java.io.Serializable;

public class A implements Serializable {

    private static final long serialVersionUID = 2L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
