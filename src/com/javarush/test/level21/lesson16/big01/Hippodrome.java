package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by 45 on 04.01.2017.
 */
public class Hippodrome {
    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double maxDistance = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));

    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();

        game.getHorses().add(new Horse("First", 3, 0));
        game.getHorses().add(new Horse("Second", 3, 0));
        game.getHorses().add(new Horse("Third", 3, 0));

        game.run();
        game.printWinner();
    }

}
