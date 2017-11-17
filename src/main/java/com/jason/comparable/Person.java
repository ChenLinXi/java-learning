package com.jason.comparable;

public class Person implements Comparable<Person> {

    private int age;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Person person) {
        return Integer.compare(age, person.age);
    }
}
