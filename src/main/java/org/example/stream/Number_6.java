package org.example.stream;

import org.example.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/// Задача:
/// Отфильтровать список, оставив только активных пользователей старше 18 лет.
/// Отсортировать их по имени в алфавитном порядке.
/// Вывести список email'ов этих пользователей.
public class Number_6 {

    public static void main(String[] args) {
        List<User> users = dataGen();

        users.stream()
                .filter(u -> u.getAge() > 18 && u.isActive())
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(s -> System.out.println(s.getName() + " " + s.getEmail()));

        List<String> list2 = users.stream()
                .filter(u -> u.isActive() && u.getAge() > 18)
                .sorted(Comparator.comparing(User::getName))
                .map(User::getEmail)
                .toList();
        System.out.println(list2);

    }





    public static List<User> dataGen(){

        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User("User" + i, 20 + i, "user" + i + "@example.com", i % 2 == 0);
            userList.add(user);
        }

        return userList;
    }
}
