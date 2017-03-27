package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.parseInt(reader.readLine());
        Integer[] intArray = new Integer[x];

        for (int i = 0; i < x; i++) {
            intArray[i] = Integer.parseInt(reader.readLine());
        }


        int maximum = intArray[0];

        for (int i = 1; i < intArray.length - 1; i++) {
            Integer max = max(intArray[i], intArray[i + 1]);
            if (max > maximum) {
                maximum = max;
            }
        }

        System.out.println(maximum);
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }

    }
}
