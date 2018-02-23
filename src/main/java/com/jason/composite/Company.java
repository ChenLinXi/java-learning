package com.jason.composite;

public abstract class Company {

    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void Add(Company company);

    public abstract void Remove(Company company);

    public abstract void Display(int depth);

    public abstract void LineOfDuty();
}
