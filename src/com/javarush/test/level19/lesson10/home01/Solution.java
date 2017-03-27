package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
            for (Map.Entry entry : hashMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException e) {
        }
    }
}
