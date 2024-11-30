package org.example.algs.original;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) {
        int [] array = new int [] {12, 9, 4, 23, 7, 8};
        int[] ints = twoSums(array, 20);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] twoSums(int[] array, int number) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < array.length; j++) {
            int temp = number - array[j];
            if(map.get(temp) != null && map.get(temp) != j){
                return new int[] {j, map.get(temp)};
            }else{
                map.put(array[j], j);
            }

        }return null;
    }


}
