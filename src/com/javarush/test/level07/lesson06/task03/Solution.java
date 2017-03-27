package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr.add(sc.nextLine());
        }
        int min = arr.get(0).length();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).length() < min) {
                min = arr.get(i).length();
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() == min) {
                System.out.println(arr.get(i));
            }
        }

    }

}
