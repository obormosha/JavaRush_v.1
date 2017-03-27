package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "мама", "мыла", "раму");

        for (int i = 0; i< arrayList.size(); i++) {
            if (arrayList.get(i).equals("мама")){
                arrayList.add(i+1, "именно");
            }
            if (arrayList.get(i).equals("мыла")){
                arrayList.add(i+1, "именно");
            }
            if (arrayList.get(i).equals("раму")){
                arrayList.add(i+1, "именно");
            }

        }


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }


    }
}
