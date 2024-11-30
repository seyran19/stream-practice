package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Дан список строк, представляющий собой набор предложений. Задача: подсчитать частоту встречаемости
///  каждого уникального слова (игнорируя регистр) и вывести топ-5 самых частых слов.
public class Number_4 {

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java is a programming language",
                "Stream API in Java is powerful",
                "Java allows functional programming",
                "Stream processing is efficient"
        );

        List<String> list = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(w -> w.toLowerCase())
                .collect(
                        Collectors.groupingBy(
                                e -> e,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .sorted((a, b) -> (int) (b.getValue() - a.getValue()))
                .map(e -> e.getKey())
                .limit(5)
                .toList();

        System.out.println(list);
        List<String> list2 = sentences.stream()
                .flatMap(e -> Arrays.stream(e.split(" ")))
                .map(String::toLowerCase)
                .collect(
                        Collectors.groupingBy(
                                e -> e,
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .sorted((a, b) -> (int) (b.getValue() - a.getValue()))
                .map(e -> e.getKey())
                .limit(5)
                .toList();
        System.out.println(list2);

    }
}
