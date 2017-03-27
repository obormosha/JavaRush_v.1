package com.javarush.test.level20.lesson02.task03;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 45 on 02.01.2017.
 */
public class IteratorTest {
    private static final int size = 3_000_000;
    static Map<String, String> test = new HashMap<>(size);
    static Map<String, String> test2 = new HashMap<>(size);
    static Map<String, String> test3 = new HashMap<>(size);
    static Map<String, Long[]> results = new HashMap<>();
    static long startTime = System.nanoTime();
    static int leaps = 10;


    public static void main(String[] args) {

        for (int i = 0; i < size; i++) {
            test.put(UUID.randomUUID().toString(), "nothing");
        }
        System.out.println("map formed: " + formatTime(System.nanoTime() - startTime));
        for (String key : test.keySet()) {
            test2.put(key, test.get(key));
        }

        for (int leap = 0; leap < leaps; leap++) {
            keySet(leap);
            entrySet(leap);
        }
        Double tmp = null;
        for (String key : results.keySet()) {
            long avg = avg(results.get(key));
            System.out.println(key + " avg: " + formatTime(avg));
            if (tmp == null) {
                tmp = (double) avg;
            } else {
                System.out.println("Proportion: " + avg / tmp);
            }
        }
    }

    protected static Long avg(Long[] res) {
        long sum = 0;
        for (Long l : res) {
            System.out.println("step result = " + formatTime(l));
            sum += l;
        }
        return sum / res.length;
    }

    protected static void entrySet(int leap) {
        startTime = System.nanoTime();
        test3 = new HashMap<>(size);
        for (Map.Entry<String, String> entry : test.entrySet()) {
            test3.put(entry.getKey(), entry.getValue());
        }
        addToResults("entrySet", leap);
    }

    protected static void addToResults(String key, int leap) {
        long delta = (System.nanoTime() - startTime);
        Long[] res = results.get(key);
        if (res == null) {
            res = new Long[leaps];
        }
        res[leap] = delta;
        results.put(key, res);
    }

    protected static void keySet(int leap) {
        startTime = System.nanoTime();
        test2 = new HashMap<>(size);
        for (String key : test.keySet()) {
            test2.put(key, test.get(key));
        }
        addToResults("keySet", leap);
    }

    public static String formatTime(long nanoseconds) {


        long seconds = nanoseconds / 1000000000; //1 234 567 = 0c
        long miliseconds = (nanoseconds / 1000000) - seconds * 1000; //1 mls
        long microseconds = (nanoseconds / 1000) - seconds * 1000000 - miliseconds * 1000; //234 mkrs


        return seconds + ":" + miliseconds + ":" + microseconds;
    }
}
