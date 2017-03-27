package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a < b && b < c) {
            System.out.print(b);
        } else if (a < c && c < b) {
            System.out.print(c);
        } else if (a > b && b > c) {
            System.out.print(b);
        } else if (a > c && c > b) {
            System.out.print(c);
        } else {
            System.out.print(a);
        }

    }
}
