package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            String name3 = reader.readLine();
            FileInputStream file1 = new FileInputStream(name1);
            FileOutputStream file2 = new FileOutputStream(name2);
            FileOutputStream file3 = new FileOutputStream(name3);

            byte[] buffer = new byte[file1.available()];

            while (file1.available() > 0) {
                file1.read(buffer);
            }
            int total = buffer.length;
            int half = total / 2;
            if (total % 2 != 0) {
                half = total / 2 + 1;
            }
            for (int i = 0; i < total; i++) {
                if (i < half) {
                    file2.write(buffer[i]);
                } else {
                    file3.write(buffer[i]);
                }
            }

            reader.close();
            file1.close();
            file2.close();
            file3.close();
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }
    }
}
