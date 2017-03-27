package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
            Pattern p = Pattern.compile(".*\\d+.*");
            FileWriter fileWriter = new FileWriter(args[1]);
            while (buffer.ready()) {
                String[] splitText = buffer.readLine().split(" ");
                for (String s : splitText) {
                    Matcher m = p.matcher(s);
                    if (m.matches()) {
                        fileWriter.write(s + " ");
                    }
                }
            }
            buffer.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
