package com.javarush.test.level20.lesson10.bonus01;

import java.util.TreeSet;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {


    public static boolean check(int i) {
        int balance = i;
        int left = 0;
        int right = 0;
        while (balance > 0) {
            left = balance % 10;
            if (right > left) {
                return false;
            }

            right = left;
            balance /= 10;
        }
        return true;
    }

    public static int calculate(int i) {
        int length = ("" + i).length();
        int balance = i;
        int left = 0;
        int sum = 0;
        while (balance > 0) {
            left = balance % 10;
            balance /= 10;
            sum += Math.pow(left, length);
        }
        return sum;
    }

    public static int[] getNumbers(int N) {

        TreeSet<Integer> res = new TreeSet<>();

        for (int i = 1; i < 10; i++) {
            if (i <= N) {
                res.add(i);
            }
        }
        if (N >= 10) {
            for (int i = 10; i < Integer.MAX_VALUE; i++) {
                if (check(i)) {
                    int sumCheck = calculate(i);
                    if (sumCheck > 100) {
                        int sum = calculate(sumCheck);
                        if (sumCheck == sum) {
                            if (sum >= N) {
                                break;
                            }
                            res.add(sum);
                        }
                    }
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.pollFirst();

        }
        return result;
    }

}
