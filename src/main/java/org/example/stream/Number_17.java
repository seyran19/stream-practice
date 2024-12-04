package org.example.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Разделить каждое предложение на слова.
/// Привести все слова к нижнему регистру.
/// Удалить знаки пунктуации.
/// Подсчитать, сколько раз каждое слово встречается во всем списке.
/// Вывести 5 наиболее часто встречающихся слов и их частоту.
/// hello = 3
/// this = 2
/// is = 2
/// test = 2
/// world = 2
public class Number_17 {

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Hello world, hello!",
                "This is a test. This test is simple.",
                "Hello again; world!"
        );

        sentences.stream()
                .flatMap(
                        s -> Arrays.stream(s.split(" "))
                )
                .map(w -> w.toLowerCase().replaceAll("\\W", ""))
                .collect(
                        Collectors.groupingBy(
                                w -> w,
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(5)
                .forEach((element) -> {
                    System.out.println(element.getKey() + " = " + element.getValue());
                });



    }
}
