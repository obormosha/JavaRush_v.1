package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fis = new BufferedReader(new FileReader(fileName));
        String str;
        ArrayList<String> table = new ArrayList<>();
        while ((str = fis.readLine()) != null) {
            table.add(str);
        }

        //System.out.println(table);
        fis.close();

        int maxID = 0;
        for (String s : table) {
            if (!s.isEmpty()) {
                int i = Integer.parseInt(s.substring(0, 8).replaceAll(" ", "").replaceAll("\uFEFF", ""));
                if (i > maxID) {
                    maxID = i;
                }
            }
        }
        int currentID = maxID + 1;
        FileWriter fos = new FileWriter(fileName, true);
        fos.append('\r');
        fos.append('\n');


        fos.write(String.valueOf(currentID));
        addSpaces(8, String.valueOf(currentID).length(), fos);

        //if(args[1].length())


        fos.write(args[1]);
        addSpaces(30, args[1].length(), fos);
        fos.write(args[2]);
        addSpaces(8, args[2].length(), fos);
        fos.write(args[3]);
        addSpaces(4, args[3].length(), fos);

        fos.flush();
        fos.close();
    }

    static void addSpaces(int lengthString, int currentLength, FileWriter fos) {
        int quantSpace = lengthString - currentLength;
        try {
            if (quantSpace > 0) {
                for (int i = 0; i < quantSpace; i++) {
                    fos.append(' ');
                }
            }
        } catch (Exception e) {

        }
    }
}
