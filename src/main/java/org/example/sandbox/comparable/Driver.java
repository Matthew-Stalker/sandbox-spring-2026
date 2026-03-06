package org.example.sandbox.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Person person1 = new Person("John", "Doe", 30);
        Person person2 = new Person("Jane", "Smith", 25);
        Person person3 = new Person("Alice", "Johnson", 35);
        Person person4 = new Person("Bob", "Brown", 28);
        Person person5 = new Person("Anne", "Smith", 30);

        List<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        personList.stream().forEach(System.out::println);

        Collections.sort(personList);
        personList.stream().forEach(System.out::println);

    }

}
