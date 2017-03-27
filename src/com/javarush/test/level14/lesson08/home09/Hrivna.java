package com.javarush.test.level14.lesson08.home09;

/**
 * Created by 45 on 12.10.2016.
 */
public class Hrivna extends Money {
    @Override
    public String getCurrencyName() {
        return "HRN";
    }

    public Hrivna(double amount) {
        super(amount);
    }
}
