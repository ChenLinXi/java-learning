package com.jason.innerclass;

/**
 * Java compiler will generate a pointer between inner class and the outer when constructor begins, and you can access
 * the inner class with outer class, instantiating inner class if you need.
 */
public class PersonTest {

    public static void main(String[] args) {
        // outer class access inner class based on a pointer
        Person person = new Person("chenmeng", 22);
        person.print();

        // instantiate inner class based on outer class
        Person.Decorator decorator = person.new Decorator();
        decorator.decorate();
    }
}
