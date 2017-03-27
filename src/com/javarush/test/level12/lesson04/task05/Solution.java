package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public int max(int i, int j){
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }
    public long max(long i, long j){
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }
    public double max(double i, double j){
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }

    //Напишите тут ваши методы
}
