package org.example.stream;

import java.util.List;
import java.util.stream.Collectors;

/// Выбрать студентов, которые получили средний балл больше 80.
/// Сгруппировать студентов по их факультетам.
/// Для каждого факультета вывести имя студента с его средним баллом и общее количество студентов
///  с этим факультетом, которые соответствуют условию.
///
/// Отсортировать факультеты по количеству подходящих студентов в убывающем порядке.
///
/// [
///     "Faculty: Computer Science, Students: 2, Average: [/Alice:89.0, Charlie: 91.0]",
///     "Faculty: Physics, Students: 1, Average: [/Frank:90.0]",
///     "Faculty: Mathematics, Students: 1, Average: [/Diana:85.3]"
/// ]
public class Number_27 {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Alice", "Computer Science", List.of(90, 85, 92)),
                new Student("Bob", "Mathematics", List.of(70, 75, 65)),
                new Student("Charlie", "Computer Science", List.of(95, 88, 90)),
                new Student("Diana", "Mathematics", List.of(85, 82, 89)),
                new Student("Eve", "Physics", List.of(78, 80, 84)),
                new Student("Frank", "Physics", List.of(88, 92, 90))
        );

        List<String> list = students.stream()
                .filter(s -> s.getAverageGrade() > 80)
                .collect(
                        Collectors.groupingBy(
                                Student::getFaculty

                        )
                ).entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .map(
                        s -> "Faculty: " + s.getKey() + " Students: " + s.getValue().size() + ","
                                + " Average: " + "[" + s.getValue().stream()
                                .map(st -> st.getName() + ": " + st.getAverageGrade())
                                .reduce((stud1, stud2) -> stud1 + ", " + stud2).orElse("")
                        + "]"


                ).toList();

        System.out.println(list);


    }



    static class Student {
        private String name;
        private String faculty;
        private List<Integer> grades;

        public Student(String name, String faculty, List<Integer> grades) {
            this.name = name;
            this.faculty = faculty;
            this.grades = grades;
        }

        public double getAverageGrade() {
            return grades.stream().mapToDouble(i -> i).average().orElse(0);
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public void setGrades(List<Integer> grades) {
            this.grades = grades;
        }
    }

}
