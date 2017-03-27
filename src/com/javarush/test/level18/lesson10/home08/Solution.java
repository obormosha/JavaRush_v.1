package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while (!(s = reader.readLine()).equals("exit")) {
                ReadThread readThread = new ReadThread(s);
                readThread.readFile();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        public void readFile() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                byte[] buffer = new byte[fileInputStream.available()];
                Map<String, Integer> byteMap = new HashMap<>();
                int maxCount = 0;
                while (fileInputStream.available() > 0) {
                    fileInputStream.read(buffer);
                }
                for (int i = 0; i < buffer.length - 1; i++) {
                    int count = 0;
                    for (byte b : buffer) {
                        if (buffer[i] == b) {
                            count++;
                        }
                        byteMap.put(String.valueOf(buffer[i]), count);
                        if(count > maxCount){
                            maxCount = count;
                        }
                    }
                }
                fileInputStream.close();
                for(Map.Entry<String, Integer> entry : byteMap.entrySet()){
                    String key = entry.getKey();
                    int value = entry.getValue();
                    if(value == maxCount){
                        resultMap.put(fileName, Integer.parseInt(key));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
