package com.jason.stack;

public class Stack {

    private Long size;

    public Stack(Long size) {
        this.size = size;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "{"
            + "\"size\":\"" + size + "\""
            + "}";
    }
}
