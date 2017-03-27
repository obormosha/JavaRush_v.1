package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> partsOfFile = new ArrayList<>();
        String s = null;
        try {
            while (!"end".equals(s = reader.readLine())) {
                partsOfFile.add(s);
            }

            reader.close();
        } catch (Exception e) {

        }
        if (!partsOfFile.isEmpty()) {
            File fileFully = new File(partsOfFile.get(0).substring(0, partsOfFile.get(0).lastIndexOf('.')));
            //System.out.println(fileFully.getName());
            FileOutputStream fileOutputStream = null;
            FileInputStream fileInputStream = null;

            try {
                fileOutputStream = new FileOutputStream(fileFully);
                for (int i = 1; i < partsOfFile.size() + 1; i++) {
                    fileInputStream = new FileInputStream(fileFully.getAbsolutePath() + ".part" + i);
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        fileInputStream.read(buffer);
                        fileOutputStream.write(buffer);
                    }
                }
            } catch (Exception e) {
            } finally {
                try {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
