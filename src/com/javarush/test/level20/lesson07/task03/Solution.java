package com.javarush.test.level20.lesson07.task03;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        public Person(){

        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            //out.writeChars(firstName);
            //out.writeChars(lastName);

            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            //firstName = in.readLine();
            //lastName = in.readLine();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List<Person>) in.readObject();
        }
    }
/*
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution s = new Solution();
        Person person = new Person("Ivan", "Ivanov", 45);

        File file = File.createTempFile("level20.lesson07.task03.", null, new File("E:\\test"));
        person.writeExternal(new ObjectOutputStream(new FileOutputStream(file)));

        Person person1 = new Person("", "", 0);
        person1.readExternal(new ObjectInputStream(new FileInputStream(file)));
        System.out.println(person1.firstName + " " + person1.lastName + " " + person1.father + " " + person1.children);

    }
    */
}
