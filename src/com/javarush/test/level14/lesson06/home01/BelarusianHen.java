package com.javarush.test.level14.lesson06.home01;

/**
 * Created by 45 on 11.10.2016.
 */
public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(description, Country.BELARUS, getCountOfEggsPerMonth());
    }
}
