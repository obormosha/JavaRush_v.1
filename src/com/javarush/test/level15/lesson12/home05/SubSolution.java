package com.javarush.test.level15.lesson12.home05;

/**
 * Created by 45 on 13.10.2016.
 */
public class SubSolution extends Solution {

    protected SubSolution(Solution s) {
        super(s);
    }

    protected SubSolution(int i, String s) {
        super(i, s);
    }

    protected SubSolution(double d) {
        super(d);
    }

    public SubSolution() {
    }

    public SubSolution(String s, boolean b) {
        super(s, b);
    }

    public SubSolution(Object o) {
        super(o);
    }

    SubSolution(boolean b) {
        super(b);
    }

    SubSolution(boolean b, int i) {
        super(b, i);
    }

    SubSolution(boolean b, Object o) {
        super(b, o);
    }

    private SubSolution(String s){

    }
    private SubSolution(String s, String str){}
    private SubSolution(int i){}
}
