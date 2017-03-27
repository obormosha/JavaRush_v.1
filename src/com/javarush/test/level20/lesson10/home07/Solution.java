package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String name;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.name = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(name, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
/*
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol = new Solution("E:\\test\\file.tmp");
        sol.writeObject("Hello");
        File fileForSeriazable = new File("E:\\test\\file2.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileForSeriazable));

        oos.writeObject(sol);
        //oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileForSeriazable));
        Solution sol2 = (Solution) ois.readObject();
        ois.close();

        System.out.println(sol2.toString());

        sol2.writeObject("Bye");
        System.out.println(sol2.toString());

    }*/
}
