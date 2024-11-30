package org.example.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Number_7 {

    /// Используя Stream API, подсчитайте частоту
    ///  встречаемости каждого слова (игнорируя регистр и знаки препинания).
    public static void main(String[] args) {

        String text = "Java is fun. Java is powerful. Streams are fun.";

        Map<String, Long> collect = Arrays.stream(text.split(" "))
                .map(w -> w.replaceAll("\\W", "").toLowerCase())
                .collect(
                        Collectors.groupingBy(
                                v -> v,
                                Collectors.counting()
                        )
                );
        System.out.println(collect);

        Map<String, Long> collect2 = Arrays.stream(text.split(" "))
                .map(w -> w.replaceAll("\\W", "").toLowerCase())
                .collect(
                        Collectors.groupingBy(
                                w -> w,
                                Collectors.counting()
                        )
                );
        System.out.println(collect2);

    }
}
