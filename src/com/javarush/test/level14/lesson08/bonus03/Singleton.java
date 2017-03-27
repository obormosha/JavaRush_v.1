package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by 45 on 12.10.2016.
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {

        return singleton;
    }


}
