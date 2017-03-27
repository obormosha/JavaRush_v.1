package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        SortedMap<String, Double> hashMap = new TreeMap<>();
        String[] text = new String[2];
        double maxValue = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()) {
                text = reader.readLine().split(" ");
                String lastName = text[0];
                if (hashMap.containsKey(lastName)) {
                    double currentValue = hashMap.get(lastName) + Double.parseDouble(text[1]);
                    hashMap.put(lastName, currentValue);
                } else {
                    hashMap.put(lastName, Double.parseDouble(text[1]));
                }
            }
            reader.close();
            for (Double d : hashMap.values()) {
                if (d > maxValue) {
                    maxValue = d;
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue().equals(maxValue)) {
                    System.out.println(entry.getKey());
                }
            }
        } catch (IOException e) {
        }
    }
}
