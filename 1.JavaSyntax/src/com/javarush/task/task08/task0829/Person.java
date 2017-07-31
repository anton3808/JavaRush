package com.javarush.task.task08.task0829;

public class Person {
    private String city;
    private String secondName;

    public Person(String city, String secondName) {
        this.city = city;
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public String getSecondName() {
        return secondName;
    }
}
