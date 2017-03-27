package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Byte, Integer> frequencyOfBytes = new HashMap<>();
        FileInputStream file = new FileInputStream(reader.readLine());
        int maxFrequency = 0;
        while (file.available() > 0) {
            byte data = (byte) file.read();
            Integer cObj = frequencyOfBytes.get(data);
            int count = cObj == null ? 1 : cObj + 1;

            frequencyOfBytes.put(data, count);
            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }
        for (byte b : frequencyOfBytes.keySet()) {
            if (maxFrequency == frequencyOfBytes.get(b)) {
                System.out.print(b + " ");
            }
        }
        reader.close();
        file.close();
    }
}
