package org.example.stream;

import java.util.List;

/// Задача:
/// Из списка сотрудников нужно выполнить следующие действия:
///
/// Оставить только сотрудников старше 30 лет.
/// Отсортировать их по убыванию зарплаты.
/// Вернуть топ-3 сотрудника с самой высокой зарплатой.
/// Собрать результат в строку формата "Имя: [/name], Должность: [/position]", разделяя сотрудников точкой с запятой ;.
/// Имя: David, Должность: Director; Имя: Bob, Должность: Manager; Имя: Charlie, Должность: Developer
public class Number_19 {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 28, "Developer", 3000),
                new Employee("Bob", 35, "Manager", 8000),
                new Employee("Charlie", 32, "Developer", 5000),
                new Employee("David", 45, "Director", 10000),
                new Employee("Eve", 38, "QA Engineer", 4000)
        );

        String s = employees.stream()
                .filter(d -> d.getAge() > 30)
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .limit(3)
                .map(d -> "Name: " + d.getName() + ", " + "Position: " + d.getPosition())
                .reduce((a, b) -> a + "; " + b)
                .get();
        System.out.println(s);

    }



    static class Employee {
        private String name;
        private int age;
        private String position;
        private double salary;

        public Employee(String name, int age, String position, double salary) {
            this.name = name;
            this.age = age;
            this.position = position;
            this.salary = salary;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getPosition() { return position; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("Employee{name='%s', age=%d, position='%s', salary=%.2f}", name, age, position, salary);
        }
    }

}
