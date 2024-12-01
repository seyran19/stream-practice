package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/// Задача:
///
/// Объедините оба списка.
/// Преобразуйте все имена к единому регистру (например, к нижнему).
/// Удалите дубликаты.
/// Отсортируйте имена в алфавитном порядке.
/// Верните отсортированный список уникальных имен.
public class Number_12 {

    public static void main(String[] args) {
        List<String> names1 = generateNames1();
        List<String> names2 = generateNames2();

        System.out.println("List 1: " + names1);
        System.out.println("List 2: " + names2);

        List<String> list = Stream.concat(names1.stream(), names2.stream())
                .map(n -> n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase())
                .sorted(String::compareTo)
                .distinct()
                .toList();

        System.out.println(list);


    }



    public static List<String> generateNames1() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");
        names.add("Eve");
        return names;
    }

    public static List<String> generateNames2() {
        List<String> names = new ArrayList<>();
        names.add("ALICE");
        names.add("BOB");
        names.add("CHARLIE");
        names.add("DIANA");
        names.add("EVE");
        return names;
    }

}
