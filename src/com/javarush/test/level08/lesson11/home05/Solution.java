package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        List<Character> list = new ArrayList<>();

        if (s.charAt(0) != ' ') {
            char start = Character.toUpperCase(s.charAt(0));
            list.add(start);
        } else  {
            list.add(s.charAt(0));
        }

        for (int i = 0; i <s.length()-1; i++){

            if (s.charAt(i) == ' '){
                char charNext = Character.toUpperCase(s.charAt(i+1));
                list.add(charNext);
                } else {
                list.add(s.charAt(i+1));
            }

        }

        for (Character ch : list)


        {
        System.out.print(ch);
        }


    }


}
