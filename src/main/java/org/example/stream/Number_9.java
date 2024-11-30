package org.example.stream;

import org.example.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/// Фильтрация и группировка студентов по курсам
/// У вас есть список студентов, каждый из которых содержит
///  имя и список курсов, которые он посещает. Необходимо с использованием
///  Stream API отфильтровать студентов, которые посещают более 2 курсов, и сгруппировать их по количеству
///  посещаемых курсов. В результате должен быть выведен список студентов для каждой группы (по количеству курсов).
public class Number_9 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student johnDoe = new Student("John Doe", 1, 3.6);
        johnDoe.add("Music");
        johnDoe.add("Football");
        johnDoe.add("Running");
        johnDoe.add("Swimming");
        students.add(johnDoe);


        Student MariaGonzalez = new Student("Maria Gonzalez", 1, 3.9);
        MariaGonzalez.add("Music");
        MariaGonzalez.add("Football");
        MariaGonzalez.add("Running");
        students.add(MariaGonzalez);

        Student MichaelBrown = new Student("Michael Brown", 2, 2.9);
        MichaelBrown.add("Music");
        MichaelBrown.add("Football");
        MichaelBrown.add("Running");
        students.add(MichaelBrown);


        Student janeSmith = new Student("Jane Smith", 2, 3.8);
        janeSmith.add("Music");
        janeSmith.add("Football");
        students.add(janeSmith);

        Student alexJohnson = new Student("Alex Johnson", 3, 3.4);
        alexJohnson.add("Music");
        students.add(alexJohnson);

        Map<Integer, List<String>> collect = students.stream()
                .filter(s -> s.getCourses() != null && s.getCourses().size() > 2)
                .collect(
                        Collectors.groupingBy(
                                s -> s.getCourses().size(),
                                Collectors.mapping(Student::getName, Collectors.toList())
                        )
                );
        System.out.println(collect);



    }
}
