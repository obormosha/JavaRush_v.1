package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        String result = outputStream.toString();

        String[] text = result.split(" ");
        Integer answer = null;
        if ("+".equals(text[1])) {
            answer = Integer.parseInt(text[0]) + Integer.parseInt(text[2]);
        } else if ("-".equals(text[1])) {
            answer = Integer.parseInt(text[0]) - Integer.parseInt(text[2]);
        } else if ("*".equals(text[1])) {
            answer = Integer.parseInt(text[0]) * Integer.parseInt(text[2]);
        }
        System.setOut(console);
        if (answer != null) {
            System.out.println(text[0] + " " + text[1] + " " + text[2] + " " + text[3] + " " + answer.toString());
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

