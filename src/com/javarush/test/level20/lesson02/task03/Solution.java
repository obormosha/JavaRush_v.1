package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/

public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            load(new FileInputStream(reader.readLine()));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (String key : properties.keySet()) {
            prop.setProperty(key, properties.get(key));
        }
        prop.store(outputStream, null);
    }
    /*public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            printWriter.println(entry.getKey() + " = " + entry.getValue());
        }
        printWriter.flush();
        outputStream.close();
    }*/

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }
        inputStream.close();
    }

/*
    public static void main(String[] args) {
        Solution example = new Solution();

        //example.fillInPropertiesMap();


        try {

            File your_file_name = File.createTempFile("your_file_name", null, new File("E:\\test"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            example.save(outputStream);

            example.load(new FileInputStream("E:\\test\\prop.properties"));


            outputStream.close();
            inputStream.close();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
*/
}
