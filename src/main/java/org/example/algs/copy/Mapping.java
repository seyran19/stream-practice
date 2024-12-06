package org.example.algs.copy;

import java.util.HashMap;
import java.util.Map;

public class Mapping {


    public static void main(String[] args) {
        String s ="AGG";     /// AGS  ///foo    bar
        String s2 = "Edd";  /// Edd   /// bar   foo
        System.out.println(compare(s, s2));
    }

    /// A -> E;        A -> E   f->b    b -> f
    /// G -> d;        G -> d   o->a    a -> o
    /// G -> d;        S -> d   o->r    r -> o

    public static Boolean compare(String s1, String s2){

        Map<Character, Character> map = new HashMap<>();


        if(s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            Character temps1 = s1.charAt(i);
            Character temps2 = s2.charAt(i);
            if((map.containsKey(temps1) && map.get(temps1) != temps2)){
                return false;
            } else if (map.containsValue(temps2) && !map.containsKey(temps1)) {
                return false;
            }
            map.put(temps1, temps2);

        }

        return true;
    }


}
