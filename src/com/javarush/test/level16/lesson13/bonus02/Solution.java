package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
   /* public static void main(String[] args) throws InterruptedException {
        //threads.get(0).start();
        // threads.get(1).start();

        //  threads.get(2).start();

        MessageThread t = new MessageThread();
        t.start();
        System.out.println(t.isAlive());
            Thread.sleep(1000);
        System.out.println(t.isAlive());
        t.showWarning();
        threads.get(1).interrupt();

        // threads.get(4).start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());

    }*/

    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new InterruptedThread());
        threads.add(new UraThread());
        threads.add(new MessageThread());
        threads.add(new NumberThread());

    }

    public static class InfinityThread extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class InterruptedThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class UraThread extends Thread {
        @Override
        public void run() {
            try {
                while (!currentThread().isInterrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        @Override
        public void run() {
            while (!this.isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            try {
                this.interrupt();
                this.join();
            } catch (InterruptedException e) {
            }
        }
    }

    public static class NumberThread extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = "";
                ArrayList<Integer> list = new ArrayList();
                while (!(input = reader.readLine()).equals("N")) {
                    list.add(Integer.parseInt(input));
                }
                reader.close();
                int sum = 0;
                for (Integer i : list) {
                    sum += i;
                }
                System.out.println(sum);
            } catch (Exception e) {

            }
        }
    }
}

