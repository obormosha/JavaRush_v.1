package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null, new File("E:\\test"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User ivanov = new User();
            javaRush.users.add(ivanov);
            /*ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            ivanov.setBirthDate(new Date("12/01/1980"));
            ivanov.setMale(true);
            ivanov.setCountry(User.Country.OTHER);*/

            User smirnova = new User();
            javaRush.users.add(smirnova);
            smirnova.setFirstName("Lena");
            smirnova.setLastName("Smirnova");
            smirnova.setBirthDate(new Date("01/12/1990"));
            smirnova.setMale(false);
            smirnova.setCountry(User.Country.RUSSIA);

            javaRush.save(outputStream);
            outputStream.flush();


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            for(User user : loadedObject.users){
                System.out.println(user.getFirstName() + " "+ user.getLastName() + " "+ user.getBirthDate() + " "+ user.isMale() + " "+ user.getCountry());
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            //SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            if (!users.isEmpty()) {
                for (User u : users) {
                    try {
                        printWriter.println(u.getFirstName());
                    } catch (Exception e) {
                        printWriter.println("");
                    }
                   try {
                        printWriter.println(u.getLastName());
                    } catch(Exception e ){
                        printWriter.println("");
                    }
                    try {
                        long birthDate = u.getBirthDate().getTime();
                        printWriter.println(birthDate);
                    } catch (Exception e) {
                        printWriter.println(0);
                    }
                    try {
                        boolean b = u.isMale();
                        printWriter.println(b);
                    } catch (Exception e) {
                        printWriter.println("false");
                    }

                    try {
                        printWriter.println(u.getCountry().getDisplayedName());
                    } catch (Exception e) {
                        printWriter.println("Other");
                    }

                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            //JavaRush javaRush = new JavaRush();
            if (users.isEmpty()) {
                users = new ArrayList<User>();
            }
            //SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            while (buffer.ready()) {
                User user = new User();
                users.add(user);
                user.setFirstName(buffer.readLine());
                user.setLastName(buffer.readLine());
                user.setBirthDate(new Date(Long.parseLong(buffer.readLine())));
                if (buffer.readLine() == "true") {
                    user.setMale(true);
                } else {
                    user.setMale(false);
                }
                String country = buffer.readLine();
                if (country.equals("Ukraine")) {
                    user.setCountry(User.Country.UKRAINE);
                } else if (country.equals("Russia")) {
                    user.setCountry(User.Country.RUSSIA);
                } else if (country.equals("Other")) {
                    user.setCountry(User.Country.OTHER);
                }
            }
        }
    }
}
