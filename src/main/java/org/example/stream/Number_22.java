package org.example.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Из списка студентов оставить только тех, у кого средняя оценка по всем предметам выше 75.
/// Отсортировать студентов по убыванию их средней оценки.
/// Вывести топ-3 студентов в формате: "Имя: [/name], Средний балл: [/averageGrade]".
/// Если студентов меньше 3, вывести столько, сколько есть.
public class Number_22 {


    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Alice", Map.of("Math", 80, "Physics", 90, "Chemistry", 70)),
                new Student("Bob", Map.of("Math", 60, "Physics", 65, "Chemistry", 55)),
                new Student("Charlie", Map.of("Math", 95, "Physics", 85, "Chemistry", 100)),
                new Student("Dave", Map.of("Math", 78, "Physics", 88, "Chemistry", 76)),
                new Student("Eve", Map.of("Math", 55, "Physics", 65, "Chemistry", 60))
        );

        List<String> list = students.stream()
                .collect(
                        Collectors.toMap(
                                Student::getName,
                                Student::getGrades
                        )
                ).entrySet()
                .stream()
                .filter(
                        s -> s.getValue().values().stream().reduce((a, b) -> a + b).get() > 225
                )
                .sorted((a, b) -> a.getValue().values().stream().reduce((c, d) -> c + d).orElse(0)
                        - b.getValue().values().stream().reduce((c, d) -> c + d).orElse(0))
                .map(s -> "Name: " + s.getKey() + " " + (double) s.getValue().values().stream().reduce((c, d) -> c + d).orElse(0) / s.getValue().size())
                .toList();
        System.out.println(list);



    }

    static class Student {
        private String name;
        private Map<String, Integer> grades; // Предмет -> Оценка

        public Student(String name, Map<String, Integer> grades) {
            this.name = name;
            this.grades = grades;
        }

        public String getName() { return name; }
        public Map<String, Integer> getGrades() { return grades; }
    }



}
