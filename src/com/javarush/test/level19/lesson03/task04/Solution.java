package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner sc;

        PersonScannerAdapter(Scanner scanner) {
            this.sc = scanner;
        }

        @Override
        public Person read() throws IOException {
            String[] text = sc.nextLine().split(" ");
            try {
                return new Person(text[1], text[2], text[0], new Date(Integer.valueOf(text[5]) - 1900, Integer.valueOf(text[4]) - 1, Integer.valueOf(text[3])));
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }

        @Override
        public void close() throws IOException {

        }
    }
}
