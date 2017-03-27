package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную
 сумму.
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        while (sc.hasNext()) {
            String s = sc.nextLine().toString();
            if (s.equals("сумма")) {
                System.out.println(sum);
                break;
            } else {
                Integer s1 = Integer.parseInt(s);
                sum = sum + s1;
                }
        }

    }
}
