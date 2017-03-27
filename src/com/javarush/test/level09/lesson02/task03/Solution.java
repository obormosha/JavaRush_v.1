package com.javarush.test.level09.lesson02.task03;

/* Метод должен вернуть номер строки кода, из которого вызвали этот метод
Написать пять методов, которые вызывают друг друга. Метод должен вернуть номер строки кода, из которого вызвали этот метод.
Воспользуйся функцией: element.getLineNumber().
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static int method1()
    {
        method2();
        StackTraceElement[] stack1 = Thread.currentThread().getStackTrace();
        int line = stack1[2].getLineNumber();

        return line;
    }

    public static int method2()
    {
        method3();
        StackTraceElement[] stack2 = Thread.currentThread().getStackTrace();
        int line = stack2[2].getLineNumber();

        return line;
    }

    public static int method3()
    {
        method4();
        StackTraceElement[] stack3 = Thread.currentThread().getStackTrace();
        int line = stack3[2].getLineNumber();

        return line;
    }

    public static int method4()
    {
        method5();
        StackTraceElement[] stack4 = Thread.currentThread().getStackTrace();
        int line = stack4[2].getLineNumber();

        return line;
    }

    public static int method5()
    {
        StackTraceElement[] stack5 = Thread.currentThread().getStackTrace();
        int line = stack5[2].getLineNumber();

        return line;
    }
}
