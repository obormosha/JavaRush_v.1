package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try {
            FileInputStream file = new FileInputStream(reader.readLine());
            byte[] buffer = new byte[file.available()];
            while (file.available() > 0) {
                file.read(buffer);
            }
            for (byte b : buffer) {
                if (b == 44) {
                    count++;
                }
            }
            reader.close();
            file.close();
            System.out.println(count);
        } catch (Exception e) {

        }
    }
}
