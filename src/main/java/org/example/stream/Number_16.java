package org.example.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Задача:
///
/// Отфильтруйте пользователей старше 18 лет.
/// Преобразуйте имена пользователей в верхний регистр.
/// Сгруппируйте пользователей по городу.
/// Для каждой группы отсортируйте пользователей по возрасту в порядке убывания.
/// Выведите результат в следующем формате:
/// New York: [/ CHARLIE(30), ALICE (25)]
/// Chicago: [/ DIANA(22), EVE (19)]
public class Number_16 {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 25, "New York", List.of("Reading", "Swimming")),
                new User("Bob", 17, "Los Angeles", List.of("Gaming", "Cycling")),
                new User("Charlie", 30, "New York", List.of("Cooking", "Hiking")),
                new User("Diana", 22, "Chicago", List.of("Painting")),
                new User("Eve", 19, "Chicago", List.of("Dancing"))
        );

        Map<String, List<String>> collect = users.stream()
                .filter(u -> u.getAge() > 18)
                .sorted((a, b) -> Integer.compare(b.getAge(), a.getAge()))
                .collect(
                        Collectors.groupingBy(
                                User::getCity,
                                Collectors.mapping(user -> user.getName().toUpperCase() + " " + "( " + user.getAge() + " )", Collectors.toList())
                        )
                );
        System.out.println(collect);


    }





    public static class User {
        private String name;
        private int age;
        private String city;
        private List<String> hobbies;

        public User(String name, int age, String city, List<String> hobbies) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.hobbies = hobbies;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<String> getHobbies() {
            return hobbies;
        }

        public void setHobbies(List<String> hobbies) {
            this.hobbies = hobbies;
        }
    }

}
