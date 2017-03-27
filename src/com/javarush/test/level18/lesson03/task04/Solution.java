package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Byte, Integer> frequencyOfBytes = new HashMap<>();
        FileInputStream file = new FileInputStream(reader.readLine());

        while (file.available() > 0) {
            byte data = (byte) file.read();
            Integer cObj = frequencyOfBytes.get(data);
            int count = cObj == null ? 1 : cObj + 1;

            frequencyOfBytes.put(data, count);
        }

        int minFrequency = frequencyOfBytes.get(frequencyOfBytes.keySet().iterator().next());
        for (int i : frequencyOfBytes.values()) {
            if (i < minFrequency) {
                minFrequency = i;
            }
        }

        for (byte b : frequencyOfBytes.keySet()) {
            if (frequencyOfBytes.get(b) == minFrequency) {
                System.out.print(b + " ");
            }
        }

        reader.close();
        file.close();
    }
}
