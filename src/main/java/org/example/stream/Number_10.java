package org.example.stream;

import org.example.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Дан список транзакций, каждая из которых содержит сумму и тип (например, "доход" или "расход").
///  Используя Stream API, найдите сумму всех уникальных "доходов" и "расходов" отдельно.
public class Number_10 {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();


        for (int i = 1; i <= 10; i++) {
            double amount = i * 100.0; // Пример суммы
            String type = i % 2 == 0 ? "dohod" : "rashod"; // Чередование типа


            transactions.add(new Transaction(amount, type));


        }
        Map<String, Double> collect = transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                t -> t.getType(),
                                Collectors.summingDouble(Transaction::getAmount)
                        )
                );
        System.out.println(collect);


    }
}
