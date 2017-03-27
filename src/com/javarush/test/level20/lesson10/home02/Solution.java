package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        Object object = objectStream.readObject();
        objectStream.close();
        if (object instanceof B) {
            B b = (B) object;
            return b;
        } else if (object instanceof A) {
            A a = (A) object;
            return a;
        }
        return null;
    }

    public class A implements Serializable {

    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

/*
    public static void main(String[] args) {
        Solution sol = new Solution();
        A firstA = sol.new A();
        B b = sol.new B();

        try {
            //ile file = File.createTempFile("level20.lesson10.home02.", null, new File("E:\\test"));
            //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            //oos.writeObject(firstA);
            //oos.close();

            File file2 = File.createTempFile("level20.lesson10.home02.", null, new File("E:\\test"));
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
            oos2.writeObject(b);
            oos2.close();

            //ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file2));

            //System.out.println(sol.getOriginalObject(ois));
            System.out.println(sol.getOriginalObject(ois2).getClass());

            //ois.close();
            ois2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }*/
}
