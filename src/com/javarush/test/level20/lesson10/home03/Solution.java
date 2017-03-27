package com.javarush.test.level20.lesson10.home03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A() {
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
        }
    }


/*
    public static void main(String[] args) {
        Solution sol = new Solution();

        B b = sol.new B("name B ");
        System.out.println(b.name);

        try {
            File file2 = File.createTempFile("level20.lesson10.home03.", null, new File("E:\\test"));
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
            oos2.writeObject(b);
            oos2.close();

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file2));
            Object object = ois2.readObject();
            ois2.close();
            B newb = (B) object;

            System.out.println(newb.name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }*/
}
