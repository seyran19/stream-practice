package org.example.stream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/// Задача:
/// Напишите метод, который:
///
/// Фильтрует только входящие транзакции (INCOMING).
/// Сортирует их по убыванию суммы.
/// Возвращает список уникальных идентификаторов (id) первых 5 транзакций.
public class Number_11 {

    public static void main(String[] args) {
        List<Transaction> transactions = generateTransactions(10);
        transactions.forEach(System.out::println);

        transactions.stream()
                .filter(t -> t.getType() == TransactionType.INCOMING)
                .sorted((a, b) -> Double.compare(b.getAmount() ,a.getAmount()))
                .map(Transaction::getId)
                .limit(5)
                .forEach(System.out::println);


    }






    public static List<Transaction> generateTransactions(int count) {
            List<Transaction> transactions = new ArrayList<>();
            Random random = new Random();

            for (int i = 1; i <= count; i++) {
                Transaction transaction = new Transaction(
                        i,
                        random.nextDouble() * 1000, // Amount between 0 and 1000
                        random.nextBoolean() ? TransactionType.INCOMING : TransactionType.OUTGOING,
                        LocalDateTime.now().minusDays(random.nextInt(30)) // Random date in the last 30 days
                );
                transactions.add(transaction);
            }

            return transactions;
        }
    }

    enum TransactionType {
        INCOMING, OUTGOING
    }

    class Transaction {
        private final int id;
        private final double amount;
        private final TransactionType type;
        private final LocalDateTime timestamp;

        public Transaction(int id, double amount, TransactionType type, LocalDateTime timestamp) {
            this.id = id;
            this.amount = amount;
            this.type = type;
            this.timestamp = timestamp;
        }

        public int getId() {
            return id;
        }

        public double getAmount() {
            return amount;
        }

        public TransactionType getType() {
            return type;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", type=" + type +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }


