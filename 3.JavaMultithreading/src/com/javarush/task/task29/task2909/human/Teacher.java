package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human {
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(false);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}