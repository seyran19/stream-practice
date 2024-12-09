package org.example.algs.original;

import java.util.Arrays;
import java.util.stream.Collectors;

/// Иннотех
///
/// Напишите метод, которы принимает строку и печатает сколько раз каждый символ повторяется в ней
public class CountOfWords {

    public static void main(String[] args) {
        String s = "abbc";
        printCountOfWords(s);
    }

    private static void printCountOfWords(String s){
        Arrays.stream(s.split(""))
                .collect(
                        Collectors.groupingBy(
                                w -> w,
                                Collectors.counting()
                        )
                ).forEach((key, val) -> System.out.println(key + " - " + val));
    }
}
