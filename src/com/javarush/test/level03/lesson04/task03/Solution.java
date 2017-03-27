package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg z1 = new Zerg();
        z1.name = "z1";
        Zerg z2 = new Zerg();
        z2.name = "z2";
        Zerg z3 = new Zerg();
        z3.name = "z3";
        Zerg z41 = new Zerg();
        z41.name = "z41";
        Zerg z51 = new Zerg();
        z51.name = "z51";
        Zerg z61 = new Zerg();
        z61.name = "z61";
        Zerg z71 = new Zerg();
        z71.name = "z71";
        Zerg z81 = new Zerg();
        z81.name = "z81";
        Zerg z91 = new Zerg();
        z91.name = "z91";
        Zerg z10 = new Zerg();
        z10.name = "z10";

        Protos p1 = new Protos();
        p1.name = "p1";
        Protos p21 = new Protos();
        p21.name = "p21";
        Protos p31 = new Protos();
        p31.name = "3";
        Protos p41 = new Protos();
        p41.name = "p14";
        Protos p51 = new Protos();
        p51.name = "p15";


        Terran t1 = new Terran();
        t1.name = "t1";
        Terran t21 = new Terran();
        t21.name = "t21";
        Terran t31 = new Terran();
        t31.name = "t31";
        Terran t41 = new Terran();
        t41.name = "t41";
        Terran t51 = new Terran();
        t51.name = "t51";
        Terran t61 = new Terran();
        t61.name = "t61";
        Terran t71 = new Terran();
        t71.name = "t71";
        Terran t81 = new Terran();
        t81.name = "t81";
        Terran t91 = new Terran();
        t91.name = "t19";
        Terran t10 = new Terran();
        t10.name = "t10";
        Terran t11 = new Terran();
        t11.name = "t11";
        Terran t12 = new Terran();
        t12.name = "t12";



    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}