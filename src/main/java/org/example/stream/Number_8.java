package org.example.stream;

import org.example.Student;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/// Сгруппировать студентов по курсам (course).
/// Для каждого курса подсчитать количество студентов и вывести их средний GPA.
public class Number_8 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe", 1, 3.6));
        students.add(new Student("Jane Smith", 2, 3.8));
        students.add(new Student("Alex Johnson", 3, 3.4));
        students.add(new Student("Maria Gonzalez", 1, 3.9));
        students.add(new Student("Michael Brown", 2, 2.9));
        students.add(new Student("Emily Davis", 3, 3.7));
        students.add(new Student("James Wilson", 1, 3.5));
        students.add(new Student("Olivia Martin", 2, 3.2));
        students.add(new Student("Liam Moore", 3, 3.0));
        students.add(new Student("Sophia Taylor", 1, 3.1));

        Map<Integer, DoubleSummaryStatistics> collect = students.stream()
                .collect(
                        Collectors.groupingBy(
                                v -> v.getCourse(),
                                Collectors.summarizingDouble(s-> s.getGpa())

                        )
                );
        collect.forEach((course, stats) -> {
            System.out.println("Course " + course + ":");
            System.out.println("Number of students: " + stats.getCount());
            System.out.println("Average GPA: " + stats.getAverage());
            System.out.println();
        });

    }


}
