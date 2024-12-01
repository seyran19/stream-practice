package org.example.stream;

import org.example.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

///  Задача:
/// Напишите метод, который:
///
/// Группирует сотрудников по отделам (department).
/// Для каждого отдела находит сотрудника с самой высокой зарплатой.
/// Возвращает Map<String, Employee>, где ключ — название отдела, значение — сотрудник с максимальной зарплатой
public class Number_13 {

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

        Map<String, Optional<Employee>> collect = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy((a, b) -> Double.compare(a.getSalary(), b.getSalary()))
                        )
                );

        System.out.println(collect);
    }
}
