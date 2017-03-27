package com.javarush.test.level15.lesson12.bonus01;


public class Plane implements Flyable {
    int countPassengers = 0;

    public Plane(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    @Override
    public void fly() {

    }
}
