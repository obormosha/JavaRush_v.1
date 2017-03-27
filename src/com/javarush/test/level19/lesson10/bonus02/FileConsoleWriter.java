package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {
    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException {
        System.out.print((char)c);
        super.write(c);

    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            System.out.print(str.toCharArray()[i]);
        }
        super.write(str, off, len);
    }



    public static void main(String[] args) throws IOException {
        FileConsoleWriter writer = new FileConsoleWriter("E:\\test\\test2.txt");
        writer.write(100);
        writer.write(" " + '\n');
        char[] cbuf = {'a', 'b', 'c'};
        writer.write(cbuf);
        writer.write(cbuf, 1, 1);
        writer.write("hello", 3, 2);
        writer.write("qwerty");
        writer.close();
    }
}
