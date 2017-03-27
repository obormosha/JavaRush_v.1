package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution_test {
    private static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }
    public static void main(String[] args){
        DataAdapter dataAdapter = new DataAdapter(new ExampleCustomer(), new ExampleContact());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            return countries.get(customer.getCountryName());
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(" ");
            return name[1];
        }

        @Override
        public String getContactLastName() {
            String[] name = contact.getName().split(" ");
            return name[0].replace(",", "");
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    static class ExampleCustomer implements Customer{
        @Override
        public String getCompanyName() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getCountryName() {
            return "Ukraine";
        }
    }
    static class ExampleContact implements Contact {
         @Override
         public String getName() {
             return "Ivanov, Ivan";
         }

         @Override
         public String getPhoneNumber() {
             return "+38(050)123-45-67";
         }
     }

}