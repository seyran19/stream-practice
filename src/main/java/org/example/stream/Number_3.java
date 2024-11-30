package org.example.stream;

import java.util.Arrays;
import java.util.List;

/// Есть список строк, каждая из которых представляет собой список чисел, разделённых запятыми (например, "1,2,3").
///  Задача: преобразовать эти строки в список уникальных чисел (целых) и отсортировать их по возрастанию.
public class Number_3 {

    public static void main(String[] args) {
        List<String> strings = List.of("1, 2, 3, 4, 4, 5, 5, 3, 7");

        List<Integer> list1 = strings.stream()
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .map(numb -> Integer.valueOf(numb))
                .sorted((a, b) -> a - b)
                .distinct()
                .toList();

        System.out.println(list1);

        List<Integer> list2 = strings.stream()
                .flatMap(
                        e -> Arrays.stream(e.split(", "))
                )
                .map(Integer::valueOf)
                .sorted()
                .distinct()
                .toList();
        System.out.println(list2);

    }
}
