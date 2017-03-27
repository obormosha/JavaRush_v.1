package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {

    public void encrypt(String fileName, String fileOutputName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            FileOutputStream fos = new FileOutputStream(fileOutputName);
            byte[] buffer = new byte[file.available()];
            byte[] encodeBuffer = new byte[buffer.length];
            while (file.available() > 0) {
                file.read(buffer);
            }
            for (int i = 0; i < buffer.length; i++) {
                encodeBuffer[i] = (byte) (buffer[i] + 1);
            }
            fos.write(encodeBuffer);

            file.close();
            fos.flush();
            fos.close();

        } catch (Exception e) {

        }

    }

    public void decrypt(String fileName, String fileOutputName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            FileOutputStream fos = new FileOutputStream(fileOutputName);
            byte[] buffer = new byte[file.available()];
            byte[] encodeBuffer = new byte[buffer.length];
            while (file.available() > 0) {
                file.read(buffer);
            }
            for (int i = 0; i < buffer.length; i++) {
                encodeBuffer[i] = (byte) (buffer[i] - 1);
            }
            fos.write(encodeBuffer);
            file.close();
            fos.flush();
            fos.close();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Solution example = new Solution();

        if (args[0].equals("-e")) {
            example.encrypt(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            example.decrypt(args[1], args[2]);
        }


    }


}
