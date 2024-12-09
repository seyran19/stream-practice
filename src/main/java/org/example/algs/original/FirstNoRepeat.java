package org.example.algs.original;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/// Найти первый не повторяющийся элемент в массиве целых чисел
public class FirstNoRepeat {

    public static void main(String[] args) {

        long[] arr = {9, 4, 9,  6, 7, 5};
        System.out.println(getFirstUnrepeatable(arr));

        Map<Long, Long> collect = Arrays.stream(arr)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                l -> l,
                                Collectors.counting()
                        )
                );

        for (int i = 0; i < arr.length; i++) {
            if(collect.get(arr[i]) == 1){
                System.out.println(arr[i]);
                return;
            }
        }



    }

    private  static Long getFirstUnrepeatable(long[] arr){
        LinkedHashMap<Long, Long> linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++ ){
            if (linkedHashMap.containsKey(arr[i])){
                linkedHashMap.put(arr[i], (linkedHashMap.get(arr[i]) + 1));
            }else {
                linkedHashMap.put(arr[i],  (long) 1);
            }
        }

      return linkedHashMap.entrySet().stream()
               .filter(e -> e.getValue() == 1)
               .map(e -> e.getKey())
               .findFirst().orElse(null);

    }

}
