package com.jason.composite;

public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {

    }

    @Override
    public void Remove(Company company) {

    }

    @Override
    public void Display(int depth) {
        System.out.println("-" + depth + name);
    }

    @Override
    public void LineOfDuty() {
        System.out.println("员工招聘培训管理" + name);
    }
}
