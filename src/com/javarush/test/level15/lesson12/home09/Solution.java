package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URL ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14

javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3.0
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringURL = reader.readLine();
        reader.close();
        stringURL = stringURL.substring(stringURL.indexOf("?") + 1);

        String[] parametrs = stringURL.split("&");
        String str = "";

        for (int i = 0; i < parametrs.length; i++) {
            //System.out.println(parametrs[i]);
            //проверяем есть ли у параметра название и значение, разделенные "="
            if (parametrs[i].contains("=")) {
                System.out.print(parametrs[i].substring(0, parametrs[i].indexOf("=")) + " ");
            } else {
                System.out.print(parametrs[i] + " ");
            }
        }
        System.out.println("");
        for (int i = 0; i < parametrs.length; i++) {
            if (parametrs[i].contains("=")) {
                //есть ли у параметра в названии "obj"
                if (parametrs[i].substring(0, parametrs[i].indexOf("=")).equals("obj")) {
                    //если есть "obj", то сохраняем значение параметра в отдельную строку
                    str = parametrs[i].substring(parametrs[i].indexOf("=") + 1);
                    try {
                        //пытаемся распарсить в число
                        alert(Double.parseDouble(str));
                    } catch (Exception e) {
                        //если не удалось распарсить в число - передаем в метод как строку
                        alert(str.toString());
                    }
                }
            }   //если есть "=" у параметра, то передаем на печать название
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
