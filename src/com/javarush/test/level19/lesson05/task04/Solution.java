package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(file1));
            FileOutputStream writer = new FileOutputStream(file2);

            while (fileReader.ready()) {
                String s = fileReader.readLine().replaceAll("\\.", "!");
                writer.write(s.getBytes());
                writer.write('\r');
                writer.write('\n');
            }
            fileReader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
