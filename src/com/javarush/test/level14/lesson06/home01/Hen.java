package com.javarush.test.level14.lesson06.home01;

/**
 * Created by 45 on 11.10.2016.
 */
public abstract class Hen {

    String description = " Моя страна - %s. Я несу %d яиц в месяц.";

    public abstract int getCountOfEggsPerMonth();

    public String getDescription() {
        return "Я курица.";
    }
}
