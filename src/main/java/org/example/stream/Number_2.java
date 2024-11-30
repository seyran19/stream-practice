package org.example.stream;

import org.example.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Дан список объектов класса Employee с полями name, department, salary.
///  Задача: сгруппировать сотрудников по отделам и посчитать среднюю зарплату для каждого отдела.
public class Number_2 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR", 45000));
        employees.add(new Employee("Bob", "IT", 60000));
        employees.add(new Employee("Charlie", "Finance", 75000));
        employees.add(new Employee("David", "IT", 50000));
        employees.add(new Employee("Eve", "Marketing", 70000));
        employees.add(new Employee("Frank", "HR", 55000));
        employees.add(new Employee("Grace", "Finance", 65000));
        employees.add(new Employee("Hank", "Marketing", 48000));
        employees.add(new Employee("Ivy", "IT", 52000));
        employees.add(new Employee("Jack", "Finance", 90000));

        Map<String, Double> collect1 = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(),
                        Collectors.averagingDouble(e ->  e.getSalary())));

        System.out.println(collect1);

        Map<String, Double> collect = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)

                        )
                );

        System.out.println(collect);
    }
}
