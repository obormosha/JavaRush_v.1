package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

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
                String[] text = fileReader.readLine().split(" ");
                for (String s : text) {
                    try {
                        Integer.parseInt(s);
                        byte[] b = s.getBytes();
                        writer.write(b);
                        writer.write(' ');
                    } catch (Exception e) {
                    }
                }
            }
            fileReader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
