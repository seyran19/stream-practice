package org.example.algs.original;

import java.util.HashMap;
import java.util.Map;

public class RomainToInteger {

    public static void main(String[] args) {

        int solution = Solution("MXVII");
        System.out.println(solution);

    }

    public static int Solution(String s){
        Map<String, Integer> romanMap = new HashMap<>();

        // Заполнение карты римскими цифрами и их значениями
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = romanMap.get(String.valueOf(s.charAt(i)));
            if (curr < prev){
                result -= curr;
            }else {
                result+=curr;
            }
            prev = curr;
        }
        return result;
    }


}
