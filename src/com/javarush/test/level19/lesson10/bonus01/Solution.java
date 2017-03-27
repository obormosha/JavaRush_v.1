package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();


    public static void main(String[] args) {
        ArrayList<String> linesOfFile1 = new ArrayList<>();
        ArrayList<String> linesOfFile2 = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            reader.close();


            BufferedReader bufferFile1 = new BufferedReader(new FileReader(name1));
            while (bufferFile1.ready()) {
                linesOfFile1.add(bufferFile1.readLine());
            }
            bufferFile1.close();

            BufferedReader bufferFile2 = new BufferedReader(new FileReader(name2));
            while (bufferFile2.ready()) {
                linesOfFile2.add(bufferFile2.readLine());
            }
            bufferFile2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sizeList1 = linesOfFile1.size();
        int sizeList2 = linesOfFile2.size();

        int i = 0;
        int j = 0;

        for (; i < sizeList1; ) {
            if (j < sizeList2) {
                if (linesOfFile1.get(i).equals(linesOfFile2.get(j))) {
                    lines.add(new LineItem(Type.SAME, linesOfFile1.get(i)));
                    i++;
                    j++;
                } else if (linesOfFile1.get(i + 1).equals(linesOfFile2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, linesOfFile1.get(i)));
                    i++;
                } else {
                    lines.add(new LineItem(Type.ADDED, linesOfFile2.get(j)));
                    j++;
                }
            }
        }


        if (i < sizeList1) {
            lines.add(new LineItem(Type.REMOVED, linesOfFile1.get(i)));
        } else if (j < sizeList2) {
            lines.add(new LineItem(Type.ADDED, linesOfFile2.get(j)));
        }

        //System.out.println("lines is full");
        /*
        for (LineItem l : lines) {
            System.out.println(l.type + ": " + l.line);
        }*/

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
