package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null) {
            return false;
        }
        if (n.getClass() != getClass()) {
            return false;
        }
        Solution s = (Solution) n;

        boolean a = (s.first == null && first == null)
                || ((s.first != null && first != null) && s.first.equals(this.first));
        if (s.first != null && first != null) {
            a = s.first.equals(this.first);
        }
        if (!a) {
            return false;
        }
        boolean b = s.last == null && last == null;
        if (s.last != null && last != null) {
            b = s.last.equals(this.last);
        }

        return a && b;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;


        result = PRIME * result + ((first != null ? first.hashCode() : 0) + (last != null ? last.hashCode() : 0));

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution s1 = new Solution("Donald", "Duck");
        s.add(s1);
        Solution s2 = new Solution("Donald", "Duck");
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s.contains(new Solution("Donald", "Duck")));
        Solution s3 = new Solution(null, "Duck");
        System.out.println(s1.equals(s3));
        Solution s4 = new Solution(null, "Duck");
        System.out.println(s4.equals(s3));
    }
}
