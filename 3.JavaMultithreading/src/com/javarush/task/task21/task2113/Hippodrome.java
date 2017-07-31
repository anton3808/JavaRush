package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {

    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main (String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse pegas = new Horse("Pegas",3,0);
        Horse ralph = new Horse("Ralph",3,0);
        Horse ronald = new Horse("Ronald",3,0);
        game.getHorses().add(pegas);
        game.getHorses().add(ralph);
        game.getHorses().add(ronald);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses){
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner = null;
        double maxDistance = 0;
        for(Horse horse : horses){
            if(horse.getDistance()>maxDistance){
                maxDistance = horse.getDistance();
            }
        }
        for(Horse horse : horses){
            if (horse.getDistance()==maxDistance){
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

}