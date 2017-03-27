package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //Add your code here
        try {
            int[] array = new int[3];
            for (int i = 0; i <= array.length; i++) {
                array[i]++;
            }
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object o = null;
            o.toString();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            InputStream input = new FileInputStream("");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = "";
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            ArrayList<Integer> list = new ArrayList();
            list.add(1);
            list.remove(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            File.createTempFile("", "");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] arr = new int[-5];

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = "";
            s.charAt(2);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object[] array = new String[5];
            array[0] = '*';

        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
