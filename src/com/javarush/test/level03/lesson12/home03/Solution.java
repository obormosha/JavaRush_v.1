package com.javarush.test.level03.lesson12.home03;

/* Я буду зарабатывать $50 в час
Ввести с клавиатуры число n.
Вывести на экран надпись «Я буду зарабатывать $n в час».
Пример:
Я буду зарабатывать $50 в час
*/
import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.print("Я буду зарабатывать $" + x + " в час");


        //напишите тут ваш код
    }
}