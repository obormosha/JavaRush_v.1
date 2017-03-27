package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(100.00, "$");
        labels.put(1.5, "землекопа");
        labels.put(36.5, "у меня опять");
        labels.put(5.0, "argentina yamayka");
        labels.put(9.5, "недель");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
