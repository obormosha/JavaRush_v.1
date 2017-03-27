package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte maxByte = 0;
        FileInputStream file = new FileInputStream(reader.readLine());
        while (file.available() > 0) {
            int data = file.read();
            if(data > maxByte){
                maxByte = (byte) data;
            }
        }
        System.out.println(maxByte);
        reader.close();
        file.close();
    }
}
