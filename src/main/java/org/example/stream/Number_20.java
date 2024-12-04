package org.example.stream;

import java.util.List;

/// Дан список строк. Необходимо выполнить следующие операции:
///
/// Отфильтровать строки длиной больше 5 = символов.
/// Преобразовать их в верхний регистр.
/// Удалить дубликаты.
/// Отсортировать строки в лексикографическом порядке.
/// Собрать первые 4 строки в список.
/// [/ APPLE, BANANA, CHERRY, ELDERBERRY]
public class Number_20 {
    public static void main(String[] args) {
        List<String> strings = List.of(
                "apple", "banana", "cherry", "date",
                "elderberry", "fig", "grape", "banana",
                "cherry", "honeydew"
        );
        List<String> list = strings.stream()
                .filter(s -> s.length() >= 5)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .distinct()
                .sorted(String::compareTo)
                .limit(4)
                .toList();
        System.out.println(list);

    }
}
