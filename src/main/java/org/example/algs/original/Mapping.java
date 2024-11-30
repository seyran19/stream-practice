package org.example.algs.original;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

    public static void main(String[] args) {
        String s ="AGG";
        String s2 = "Edd";
        System.out.println(compareString(s, s2));

    }

    public static boolean compareString(String s, String t){

        Map<Character, Character> map = new HashMap<>();

        if (s.length() != t.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++){

            if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            } else if (map.containsValue(t.charAt(i))){
                {
                    return false;

                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }

        }
        return true;
    }
}
