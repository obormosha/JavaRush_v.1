package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static StackTraceElement[] method1()
    {
        method2();
        StackTraceElement[] stack1 = Thread.currentThread().getStackTrace();
        return stack1;

    }

    public static StackTraceElement[] method2()
    {
        method3();
        StackTraceElement[] stack2 = Thread.currentThread().getStackTrace();
        return stack2;

    }

    public static StackTraceElement[] method3()
    {
        method4();
        StackTraceElement[] stack3 = Thread.currentThread().getStackTrace();
        return stack3;

    }

    public static StackTraceElement[] method4()
    {
        method5();
        StackTraceElement[] stack4 = Thread.currentThread().getStackTrace();
        return stack4;

    }

    public static StackTraceElement[] method5()
    {
        StackTraceElement[] stack5 = Thread.currentThread().getStackTrace();
        return stack5;

    }
}
