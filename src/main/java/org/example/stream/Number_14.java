package org.example.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Задача:
/// Напишите метод, который:
///
/// Преобразует эту мапу в обратную: Map<String, Integer>, где ключ — название продукта, а значение — номер категории.
/// Обратите внимание, что один продукт может относиться только к одной категории (в случае дубликатов берется первый найденный).
public class Number_14 {

    public static void main(String[] args) {
        List<String> list1 = List.of("Banana", "Apple", "Mango");
        List<String> list2 = List.of("Lipton", "Cola", "Sprite");

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, list1);
        map.put(2, list2);

        Map<String, Integer> map2 = new HashMap<>();

//        map.entrySet().stream()
//                .map(m -> {
//                    for (String s : m.getValue()){
//                        map2.put(s, m.getKey());
//                    }
//                    return map2;
//
//                }).forEach(s -> System.out.println());

        Map<String, Integer> collect = map.entrySet().stream()
                .flatMap(
                        entry -> entry.getValue().stream()
                                .map(v -> Map.entry(v, entry.getKey()))
                ).collect(
                        Collectors.toMap(
                                r -> r.getKey(),
                                r -> r.getValue()
                        )
                );

        System.out.println(collect);





    }
}
