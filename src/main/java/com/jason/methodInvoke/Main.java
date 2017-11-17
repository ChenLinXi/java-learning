package com.jason.methodInvoke;

import com.jason.methodInvoke.adapter.PersonAdapter;
import com.jason.methodInvoke.entity.Person;
import com.jason.methodInvoke.service.impl.MainServiceImpl;

public class Main {

    public static void main(String[] args) throws Exception {
        // 调用主功能
        // 1. 调用子功能
        // 2. 子功能继承抽象父类的protected方法
        MainServiceImpl mainService = new MainServiceImpl();

        System.out.println(mainService.hello("chenmeng"));

        Person person = new Person();
        person.setAge(12);

        PersonAdapter adapter = new PersonAdapter();
        adapter.doInvoke(person, "introduce");
    }
}
