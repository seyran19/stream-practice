package org.example.stream;

import java.util.List;


/// Найти заказы, в которых суммарная стоимость товаров из категории "Electronics" превышает 500.
/// Отсортировать такие заказы по убыванию их общей стоимости.
/// Преобразовать результат в список строк формата:
/// OrderID: {orderId}, Customer: {customerName}, Total: {totalSum}
///
/// OrderId: 1 Customer: Alice Total: 1245.0
/// OrderId: 2 Customer: Bob Total: 850.0
/// OrderId: 3 Customer: Charlie Total: 600.0
public class Number_25 {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Alice", List.of(
                        new Item("Laptop", "Electronics", 1, 1200.0),
                        new Item("Book", "Books", 3, 15.0)
                )),
                new Order(2, "Bob", List.of(
                        new Item("Smartphone", "Electronics", 2, 400.0),
                        new Item("Headphones", "Electronics", 1, 50.0)
                )),
                new Order(3, "Charlie", List.of(
                        new Item("Tablet", "Electronics", 1, 300.0),
                        new Item("Monitor", "Electronics", 2, 150.0)
                )),
                new Order(4, "Diana", List.of(
                        new Item("Desk", "Furniture", 1, 200.0),
                        new Item("Chair", "Furniture", 2, 100.0)
                ))
        );

        orders.stream()
                .filter(
                        o -> o.getItems().stream()
                                .filter(i -> i.getCategory().equals("Electronics"))
                                .map(Item::getTotalPrice)
                                .reduce((a, b) -> a + b).orElse((double) 0) > 500
                ).sorted((a, b) -> Double.compare(b.getItems().stream()
                        .map(i -> i.getTotalPrice())
                        .findFirst().orElse((double) 0), a.getItems().stream()
                        .map(i -> i.getTotalPrice())
                        .findFirst().orElse((double) 0)))
                .map(s -> "OrderId: " + s.getId() + " Customer: " + s.getCustomerName() + " Total: "
                        + s.getItems().stream()
                        .map(i -> i.getTotalPrice())
                        .reduce((a, b) -> a + b).orElse((double) 0))
                .forEach(s -> System.out.println(s));


    }

    static class Order {
        private final int id;
        private final String customerName;
        private final List<Item> items;

        public Order(int id, String customerName, List<Item> items) {
            this.id = id;
            this.customerName = customerName;
            this.items = items;
        }

        public int getId() {
            return id;
        }

        public String getCustomerName() {
            return customerName;
        }

        public List<Item> getItems() {
            return items;
        }
    }

    static class Item {
        private final String name;
        private final String category;
        private final int quantity;
        private final double pricePerUnit;

        public Item(String name, String category, int quantity, double pricePerUnit) {
            this.name = name;
            this.category = category;
            this.quantity = quantity;
            this.pricePerUnit = pricePerUnit;
        }

        public String getCategory() {
            return category;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }

        public double getTotalPrice() {
            return quantity * pricePerUnit;
        }
    }
}
