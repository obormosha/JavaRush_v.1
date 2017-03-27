package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\bworld\\b");
        int count = 0;
        Matcher matcher;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(buffer.readLine()));
            while (fileReader.ready()) {
                String[] text = fileReader.readLine().split(" ");
                for (String s : text) {
                    matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        count++;
                    }
                }
            }

            buffer.close();
            fileReader.close();
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
