package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        System.out.println(getNOD(first, second));
    }

    public static Integer getNOD(int first, int second) {

        if (first < second) {
            int x = first;
            first = second;
            second = x;
        }

        int modulo = -1;

        while(modulo != 0){
            int quotient = first / second;
            modulo = first - quotient * second;
            first = second;
            second = modulo;
        }


        return first;
    }

}
