package com.javarush.test.level03.lesson03.task03;

/**
 * Created by 45 on 09.09.2016.
 */
public class Primer {

    private static int doA() throws Exception{
        try {
            throw new Exception();
        }
        catch (Exception e){
            return 0;
        } finally {
            return 1;
        }

    }

    private static int doB() throws Exception{
        try {
            throw new Exception();
        }
        catch (Exception e){
            throw e;
        } finally {
            return 1;
        }

    }

    private static int doC() throws Exception{
        int i =  0;
        do {
            i++;
            try{
                if(i == 5){
                    break;
                }
            } finally {
                continue;
            }

        } while (i < 10);

        return i;



    }

    public static void main(String[] args) throws Exception{
        System.out.println(doA());
        System.out.println(doB());
        System.out.println(doC());
    }

}