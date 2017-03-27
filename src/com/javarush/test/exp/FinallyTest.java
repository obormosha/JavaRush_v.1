package com.javarush.test.exp;

/**
 * Created by 45 on 09.09.2016.
 */
public class FinallyTest {

    public static void main(String[] args) {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Throwable rh) {
            System.out.println("Catched");
            System.exit(0);
        } finally {
            System.out.println("finally");
        }
        System.out.println("ext");
    }
}
