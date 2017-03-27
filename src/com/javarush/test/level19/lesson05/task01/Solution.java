package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        reader.close();

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);
        int count = 0;

        while (fileReader.ready()) {
            int data = fileReader.read();
            count++;
            if (count % 2 == 0) {
                fileWriter.write(data);
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
