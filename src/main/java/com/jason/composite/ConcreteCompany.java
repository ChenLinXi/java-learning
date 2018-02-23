package com.jason.composite;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company {

    private List<Company> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {
        children.add(company);
    }

    @Override
    public void Remove(Company company) {
        children.remove(company);
    }

    @Override
    public void Display(int depth) {
        System.out.println("-" + depth + name);

        children.forEach(company -> company.Display(depth + 2));
    }

    @Override
    public void LineOfDuty() {
        children.forEach(Company::LineOfDuty);
    }
}
