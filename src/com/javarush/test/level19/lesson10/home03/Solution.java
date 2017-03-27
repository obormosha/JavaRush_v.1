package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        String[] text = new String[6];
        String name = null;
        Date birthDate = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()) {
                text = reader.readLine().split(" ");
                birthDate = new Date(Integer.parseInt(text[text.length - 1]) - 1900, Integer.parseInt(text[text.length - 2]) - 1, Integer.parseInt(text[text.length - 3]));
                if (text.length == 4) {
                    name = text[0];
                } else if (text.length == 5) {
                    name = text[0] + " " + text[1];
                } else if (text.length == 6) {
                    name = text[0] + " " + text[1] + " " + text[2];
                }
                PEOPLE.add(new Person(name, birthDate));
            }
            reader.close();
            /*for (Person p : PEOPLE) {
                System.out.println(p.getName() + " " + p.getBirthday());
            }*/

        } catch (IOException e) {
        }


    }

}
