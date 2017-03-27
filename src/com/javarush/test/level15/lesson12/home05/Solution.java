package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    private Solution(String s){

    }
    private Solution(String s, String str){}
    private Solution(int i){}

    protected Solution(Solution s){}
    protected Solution(int i, String s){}
    protected Solution (double d){}

    public Solution(){}
    public Solution(String s, boolean b){}
    public Solution(Object o){}

    Solution(boolean b){}
    Solution(boolean b, int i){}
    Solution(boolean b, Object o){}
}

