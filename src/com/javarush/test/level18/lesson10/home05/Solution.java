package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "";
        String file2 = "";

        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(file1));
            FileWriter fileWriter = new FileWriter(file2);
            String[] str = fileReader.readLine().split(" ");
            int i;
            for(String s : str){
                i = (int) Math.round(Double.parseDouble(s));
                fileWriter.write(i + " ");
            }
            reader.close();
            fileReader.close();
            fileWriter.close();

        } catch (Exception e) {
        }
    }
}
