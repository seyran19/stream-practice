package org.example.stream;

import java.util.Arrays;
import java.util.List;

/// Найти самого возрастного клиента, которой пользуется стационарным телефоном
public class Number_24 {

    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
                new Client(1, "Alice", 30, Arrays.asList(
                        new Phone(123456789L, Phone.PhoneType.STATIONARY),
                        new Phone(987654321L, Phone.PhoneType.MOBIL)
                )),
                new Client(2, "Bob", 45, Arrays.asList(
                        new Phone(2233445566L, Phone.PhoneType.MOBIL)
                )),
                new Client(3, "Charlie", 60, Arrays.asList(
                        new Phone(1122334455L, Phone.PhoneType.STATIONARY)
                )),
                new Client(4, "Diana", 50, Arrays.asList(
                        new Phone(6677889900L, Phone.PhoneType.MOBIL),
                        new Phone(5544332211L, Phone.PhoneType.STATIONARY)
                )),
                new Client(5, "Eve", 70, Arrays.asList(
                        new Phone(7788990011L, Phone.PhoneType.STATIONARY)
                ))
        );
        Client client = clients.stream()
                .filter(c -> c.getPhones().stream()
                        .map(p -> p.type).findAny().orElse(null).equals(Phone.PhoneType.STATIONARY)
                ).max((a, b) -> Long.compare(a.getAge(), b.getAge()))
                .orElse(null);
        System.out.println(client);
    }


    static class Client {
        Integer id;
        String name;
        Integer age;
        List<Phone> phones;

        public Client(Integer id, String name, Integer age, List<Phone> phones) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.phones = phones;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<Phone> getPhones() {
            return phones;
        }

        public void setPhones(List<Phone> phones) {
            this.phones = phones;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", phones=" + phones +
                    '}';
        }
    }
    static class Phone {
        Long number;
        PhoneType type;

        enum PhoneType {
            STATIONARY,
            MOBIL
        }

        public Phone(Long number, PhoneType type) {
            this.number = number;
            this.type = type;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public PhoneType getType() {
            return type;
        }

        public void setType(PhoneType type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "number=" + number +
                    ", type=" + type +
                    '}';
        }
    }
}
