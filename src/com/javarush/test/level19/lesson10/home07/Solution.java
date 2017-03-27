package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);
            boolean isNotFirstWord = false;
            while (buffer.ready()) {
                String[] words = buffer.readLine().split(" ");
                for (String s : words) {
                    if (s.length() > 6) {
                        if (isNotFirstWord) {
                            writer.write("," + s);
                        } else {
                            writer.write(s);
                            isNotFirstWord = true;
                        }
                    }
                }
            }
            buffer.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
