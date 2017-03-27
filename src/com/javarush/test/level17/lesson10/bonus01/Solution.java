package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            switch (args[0]) {
                case "-c":
                    if (args[2].equals("ж")) {
                        allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[3])));
                        System.out.println((allPeople.size() - 1));
                    } else if (args[2].equals("м")) {
                        allPeople.add(Person.createMale(args[1], dateFormat.parse(args[3])));
                        System.out.println((allPeople.size() - 1));
                    }
                    break;
                case "-u":
                    int id_u = Integer.parseInt(args[1]);
                    allPeople.get(id_u).setName(args[2]);
                    if (args[3].equals("м")) {
                        allPeople.get(id_u).setSex(Sex.MALE);
                    } else if (args[3].equals("ж")) {
                        allPeople.get(id_u).setSex(Sex.FEMALE);
                    }
                    allPeople.get(id_u).setBirthDay(dateFormat.parse(args[4]));
                    break;
                case "-d":
                    int id_d = Integer.parseInt(args[1]);
                    //allPeople.remove(id_d);
                    allPeople.get(id_d).setBirthDay(null);
                    break;
                case "-i":
                    int id_i = Integer.parseInt(args[1]);
                    char sexLetter = 'м';
                    if (allPeople.get(id_i).getSex().equals(Sex.FEMALE)) {
                        sexLetter = 'ж';
                    }
                    SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(allPeople.get(id_i).getName() + " " + sexLetter + " " + dateFormatInput.format(allPeople.get(id_i).getBirthDay()));
            }
        } catch (Exception e) {

        }
    }
}
