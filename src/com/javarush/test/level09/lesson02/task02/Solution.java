package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его,
полученное с помощью StackTrace.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] stack1 = Thread.currentThread().getStackTrace();
        String methodName1 = stack1[2].getMethodName();

        return methodName1;
    }

    public static String method2() {
        method3();
        StackTraceElement[] stack2 = Thread.currentThread().getStackTrace();
        String methodName2 = stack2[2].getMethodName();

        return methodName2;
    }

    public static String method3() {
        method4();
        StackTraceElement[] stack3 = Thread.currentThread().getStackTrace();
        String methodName3 = stack3[2].getMethodName();

        return methodName3;
    }

    public static String method4() {
        method5();
        StackTraceElement[] stack4 = Thread.currentThread().getStackTrace();
        String methodName4 = stack4[2].getMethodName();

        return methodName4;
    }

    public static String method5() {
        StackTraceElement[] stack5 = Thread.currentThread().getStackTrace();
        String methodName5 = stack5[2].getMethodName();

        return methodName5;
    }
}
