package com.jason.methodInvoke.adapter;

import com.jason.methodInvoke.entity.Adult;
import com.jason.methodInvoke.entity.Child;
import com.jason.methodInvoke.entity.Person;
import java.lang.reflect.Method;

public class PersonAdapter {

    private int age;

    public PersonAdapter() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void doInvoke(Person person, String methodName) throws Exception {
        try {
            Class<?> clazz;
            if (person.getAge() < 18) {
                clazz = Child.class;
            } else {
                clazz = Adult.class;
            }
            //  clazz.getDeclaredMethod()
            Method method = clazz.getDeclaredMethod(methodName, (Class[]) null);
            method.invoke(checkPerson(person), (Object[]) null);
        } catch (Exception ex) {
            System.out.println("doInvoke exception: " + ex.getLocalizedMessage() + ex);
        }
    }

    private <T extends Person> T checkPerson(Person person) {
        if (person instanceof Adult) {
            Adult adult = new Adult();
            adult.setAge(person.getAge());
            adult.setName("adult");
            return (T) adult;
        } else {
            Child child = new Child();
            child.setAge(person.getAge());
            child.setName("child");
            return (T) child;
        }
    }
}
