package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        ArrayList list = new ArrayList<>();

        FileWriter out1 = new FileWriter(nameFile);

        while (true) {
            String str = reader.readLine();
            list.add(str);
            if (str.equals("exit")) {
                while (list.size() > 0) {
                    out1.write(str + "\r\n");
                    list.remove(0);
                }
                break;
            } else {
                while (list.size() > 0) {
                    out1.write(str + "\r\n");
                    list.remove(0);
                }
            }
        }

        out1.close();

    }
}
