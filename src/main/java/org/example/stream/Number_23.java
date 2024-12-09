package org.example.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Number_23 {
/// Посчитать общее количество входящих и исходящих транзакций.
/// Найти суммарную сумму всех входящих транзакций.
/// Определить клиента с наибольшей суммарной исходящей суммой.
/// Вывести результат в формате
    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction(1, "Alice", 500.0, "INCOMING"),
                new Transaction(2, "Bob", 200.0, "OUTGOING"),
                new Transaction(3, "Alice", 300.0, "OUTGOING"),
                new Transaction(4, "Charlie", 700.0, "INCOMING"),
                new Transaction(5, "Bob", 100.0, "OUTGOING"),
                new Transaction(6, "Alice", 400.0, "OUTGOING")
        );
        transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                t -> t.getType(),
                                Collectors.counting()
                        )
                ).forEach((i, o) -> System.out.println(i + ": " + o));

        Double incoming = transactions.stream()
                .filter(t -> t.getType().equals("INCOMING"))
                .map(t -> t.getAmount())
                .reduce((a, b) -> a + b).orElse(0.0);

        System.out.println("Incoming sum: " + incoming);

       transactions.stream()
                .filter(t -> t.getType().equals("OUTGOING"))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(t -> t.getClientName())
                .limit(1)
                        .forEach(c -> System.out.println("Max Outgoing client: " + c ));




    }



    static class Transaction {
        private int id;
        private String clientName;
        private double amount;
        private String type; // "INCOMING" или "OUTGOING"

        public Transaction(int id, String clientName, double amount, String type) {
            this.id = id;
            this.clientName = clientName;
            this.amount = amount;
            this.type = type;
        }

        public int getId() { return id; }
        public String getClientName() { return clientName; }
        public double getAmount() { return amount; }
        public String getType() { return type; }
    }

}
