package org.example.stream;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/// Требуется:
///
/// Получить сумму всех входящих транзакций (INCOME).
/// Найти все уникальные категории транзакций за последние 30 дней.
/// Отсортировать транзакции по времени в порядке убывания и вывести топ-5 самых последних транзакций.
/// Преобразовать транзакции в строковый формат: "ID: [/id], Amount: [/amount], Type: [/type]", и объединить их в одну строку через точку с запятой.
public class Number_18 {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, new BigDecimal("100.50"), TransactionType.INCOME, "Salary", LocalDateTime.now().minusDays(10)),
                new Transaction(2L, new BigDecimal("50.00"), TransactionType.EXPENSE, "Groceries", LocalDateTime.now().minusDays(5)),
                new Transaction(3L, new BigDecimal("200.00"), TransactionType.INCOME, "Bonus", LocalDateTime.now().minusDays(20)),
                new Transaction(4L, new BigDecimal("30.00"), TransactionType.EXPENSE, "Transport", LocalDateTime.now().minusDays(2)),
                new Transaction(5L, new BigDecimal("75.00"), TransactionType.EXPENSE, "Utilities", LocalDateTime.now().minusDays(7)),
                new Transaction(6L, new BigDecimal("300.00"), TransactionType.INCOME, "Freelance", LocalDateTime.now().minusDays(1)),
                new Transaction(7L, new BigDecimal("45.00"), TransactionType.EXPENSE, "Entertainment", LocalDateTime.now().minusDays(15))
        );

        BigDecimal sum = transactions.stream()
                .filter(t -> t.getType().equals(TransactionType.INCOME))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("sum - " + sum);


        List<String> list = transactions.stream()
                .filter(t -> LocalDateTime.now().minusDays(30).isBefore(t.getTimestamp()))
                .map(t -> t.getCategory())
                .distinct().toList();

        System.out.println(list);


        transactions.stream()
                .sorted((t, x) -> x.getTimestamp().compareTo(t.getTimestamp()))
                .limit(5)
                .forEach(t -> System.out.println(t));

        transactions.stream()
                .map(t -> {
                    return "ID: [/" + t.getId() + "]," +
                            "Amount: [/" + t.getAmount() + "], " +
                            "Type: [/" + t.getType() + "]";


                })
                .reduce((t1, t2) -> t1 + "; " + t2).ifPresent(System.out::println);


    }


    // Enum и класс транзакций
    enum TransactionType {
        INCOME, EXPENSE
    }

    static class Transaction {
        private final long id;
        private final BigDecimal amount;
        private final TransactionType type;
        private final String category;
        private final LocalDateTime timestamp;

        public Transaction(long id, BigDecimal amount, TransactionType type, String category, LocalDateTime timestamp) {
            this.id = id;
            this.amount = amount;
            this.type = type;
            this.category = category;
            this.timestamp = timestamp;
        }

        public long getId() {
            return id;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public TransactionType getType() {
            return type;
        }

        public String getCategory() {
            return category;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return String.format("Transaction{id=%d, amount=%s, type=%s, category='%s', timestamp=%s}",
                    id, amount, type, category, timestamp);
        }
    }
}
