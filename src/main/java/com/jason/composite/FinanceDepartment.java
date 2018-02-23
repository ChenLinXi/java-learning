package com.jason.composite;

public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
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
        System.out.println("公司财务收支管理" + name);
    }
}
