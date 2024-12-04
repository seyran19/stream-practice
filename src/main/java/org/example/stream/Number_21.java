package org.example.stream;

import java.util.List;
import java.util.stream.Collectors;

/// Задача:
/// Получить список всех уникальных товаров, заказанных клиентами.
/// Подсчитать общее количество каждого товара.
/// Оставить только те товары, которых заказано более 2 единиц.
/// Отсортировать товары по количеству в порядке убывания.
/// Преобразовать результат в строку формата: Товар: [/itemName], Количество: [/quantity], разделяя товары запятыми.
/// Товар: Apple, Количество: 6, Товар: Banana, Количество: 7, Товар: Cherry, Количество: 6
public class Number_21 {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Alice", List.of(new Item("Apple", 3), new Item("Banana", 2))),
                new Order(2, "Bob", List.of(new Item("Apple", 1), new Item("Cherry", 5))),
                new Order(3, "Charlie", List.of(new Item("Banana", 4), new Item("Cherry", 1))),
                new Order(4, "Dave", List.of(new Item("Apple", 2), new Item("Banana", 1)))
        );

        String s = orders.stream()
                .flatMap(o -> o.getItems().stream())
                .collect(
                        Collectors.groupingBy(
                                Item::getItemName,
                                Collectors.summingInt(Item::getQuantity)
                        )
                ).entrySet()
                .stream()
                .filter(it -> it.getValue() > 2 )
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .map(it -> "Item: " + it.getKey() + ", " + "Quantity: " + it.getValue())
                .reduce((a, b) -> a + ", " + b).orElse("We have some problems");
        System.out.println(s);


    }


    static class Order {
        private int orderId;
        private String customerName;
        private List<Item> items;

        public Order(int orderId, String customerName, List<Item> items) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.items = items;
        }

        public int getOrderId() { return orderId; }
        public String getCustomerName() { return customerName; }
        public List<Item> getItems() { return items; }
    }

    static class Item {
        private String itemName;
        private int quantity;

        public Item(String itemName, int quantity) {
            this.itemName = itemName;
            this.quantity = quantity;
        }

        public String getItemName() { return itemName; }
        public int getQuantity() { return quantity; }
    }

}
