package com.javarush.test.level03.lesson05.task03;

/* Конвертер времени
Добавьте метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
*/

public class Solution
{

    public static int convertToSeconds (int hour){
        int seconds = hour*60*60;
        System.out.println(seconds);
        return seconds;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

        convertToSeconds(1);
        convertToSeconds(30);
        //напишите тут ваш код
    }
}