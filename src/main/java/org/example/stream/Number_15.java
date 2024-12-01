package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Напишите метод, который:
///
/// Группирует продажи по региону.
/// Для каждого региона суммирует общую сумму продаж.
/// Возвращает Map<String, Double>, где ключ — регион, значение — общая сумма продаж.
public class Number_15 {

    public static void main(String[] args) {
        List<Sale> sales = new ArrayList<>();

        sales.add(new Sale("Laptop", "North America", 200));
        sales.add(new Sale("Smartphone", "Europe", 800.0));
        sales.add(new Sale("Tablet", "Asia", 400.0));
        sales.add(new Sale("Smartwatch", "South America", 200.0));
        sales.add(new Sale("Monitor", "Africa", 300.0));
        sales.add(new Sale("Laptop", "North America", 200));
        sales.add(new Sale("Smartphone", "Europe", 1293.3));
        sales.add(new Sale("Tablet", "Asia", 705.4));
        sales.add(new Sale("Smartwatch", "South America", 321.3));
        sales.add(new Sale("Monitor", "Africa", 19.0));

        Map<String, Double> collect = sales.stream()
                .collect(
                        Collectors.groupingBy(
                                Sale::getRegion,
                                Collectors.summingDouble(Sale::getAmount)
                        )
                );
        System.out.println(collect);


    }


    public static class Sale {
        private String productName;
        private String region;
        private double amount;

        public Sale(String productName, String region, double amount) {
            this.productName = productName;
            this.region = region;
            this.amount = amount;
        }

        public String getProductName() {
            return productName;
        }

        public String getRegion() {
            return region;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Sale{" +
                    "productName='" + productName + '\'' +
                    ", region='" + region + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }
}