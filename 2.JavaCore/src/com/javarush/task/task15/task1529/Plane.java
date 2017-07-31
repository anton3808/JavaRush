package com.javarush.task.task15.task1529;

/**
 * Created by Anton on 24.07.2017.
 */
public class Plane implements Flyable{
    int people;
    @Override
    public void fly() {

    }

    public Plane(int people) {
        this.people = people;
    }
}
