package com.javarush.task.task21.task2113;

import java.util.Random;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public  void move(){
        distance += Math.random()*speed;
    }

    public  void print(){
        int dst = (int)Math.floor(this.distance);

        for(int i=0;i<dst;i++){
            System.out.print(".");
        }
        System.out.println(this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
