package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (Exception e) {

        }

        if ("-u".equals(args[0])) {
            update(fileName, args[1], args[2], args[3], args[4]);
        } else if ("-d".equals(args[0])) {
            delete(fileName, args[1]);
        }

    }

    static void update(String fileName, String id, String productName, String price, String quantity) {
        String newLine = id + addSpaces(8, id.length()) + productName + addSpaces(30, productName.length());
        newLine = newLine + price + addSpaces(8, price.length()) + quantity + addSpaces(4, quantity.length());
        String str;
        try {
            BufferedReader fis = new BufferedReader(new FileReader(fileName));
            int idIntParam = Integer.parseInt(id);

            ArrayList<String> table = new ArrayList<>();
            while ((str = fis.readLine()) != null) {
                int idIntCurrent = Integer.parseInt(str.substring(0, 8).replaceAll(" ", "").replaceAll("\uFEFF", ""));
                if (idIntParam == idIntCurrent) {
                    table.add(newLine);
                } else {
                    table.add(str);
                }
            }
            fis.close();

            FileWriter fos = new FileWriter(fileName);

            for (String s : table) {
                fos.write(s);
                fos.append('\r');
                fos.append('\n');
            }
            fos.flush();
            fos.close();

        } catch (Exception e) {
        }
    }

    static void delete(String fileName, String id) {
        String str;
        try {
            BufferedReader fis = new BufferedReader(new FileReader(fileName));
            int idIntParam = Integer.parseInt(id);

            ArrayList<String> table = new ArrayList<>();
            while ((str = fis.readLine()) != null) {
                int idIntCurrent = Integer.parseInt(str.substring(0, 8).replaceAll(" ", "").replaceAll("\uFEFF", ""));
                if (idIntParam == idIntCurrent) {
                    continue;
                } else {
                    table.add(str);
                }
            }
            fis.close();

            FileWriter fos = new FileWriter(fileName);

            for (String s : table) {
                fos.write(s);
                fos.append('\r');
                fos.append('\n');
            }
            fos.flush();
            fos.close();

        } catch (Exception e) {
        }
    }

    static String addSpaces(int lengthString, int currentLength) {
        int quantSpace = lengthString - currentLength;
        String spaces = null;
        try {
            if (quantSpace > 0) {
                for (int i = 0; i < quantSpace; i++) {
                    if (spaces == null) {
                        spaces = " ";
                    } else {
                        spaces += " ";}
                    }
                }
            } catch(Exception e){

            }
            return spaces;
        }
    }
