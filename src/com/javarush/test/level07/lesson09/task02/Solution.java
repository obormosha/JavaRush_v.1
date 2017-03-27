package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayList.add(sc.nextLine());
        }

        arrayList.remove(2);

        for (int i = arrayList.size()-1; i >= 0; i--) {
            System.out.println(arrayList.get(i));
        }

    }
}
