package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Kuznezov", "Sergey");
        map.put("Smirnov", "Petr");
        map.put("Orehov", "Vladimir");
        map.put("Sidorov", "Vasya");
        map.put("Egorov", "Ivan");
        map.put("Vasin", "Vasya");
        map.put("Peskov", "Dmitry");
        map.put("Noskov", "Ilya");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (Map.Entry<String, String> pair : copy.entrySet()){
            String firstName = pair.getValue();

            if (!list.contains(firstName)){
                list.add(firstName);
            } else if (!list2.contains(firstName)){
                list2.add(firstName);
            }

        }

        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()){
            String text = iterator.next();
            removeItemFromMapByValue(map, text);

        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
