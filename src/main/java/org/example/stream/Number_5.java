package org.example.stream;

import java.util.Arrays;
import java.util.List;


/// Дан список строк, каждая из которых представляет собой предложение.
///  Задача: найти самое длинное слово среди всех предложений.
///  Если есть несколько слов одинаковой длины, выбрать первое встречающееся.
public class Number_5 {

    public static void main(String[] args) {

        List<String> sentences = List.of(
                "Java is a programming language",
                "Stream API in Java is powerful",
                "Java allows functional programming",
                "Stream processing is efficient"
        );

        sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .max((a, b) -> a.length() - b.length())
                .ifPresent(System.out::println);

        sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .sorted((a, b) -> b.length() - a.length())
                .limit(1)
                .findFirst()
                .ifPresent(System.out::println);


    }
}
