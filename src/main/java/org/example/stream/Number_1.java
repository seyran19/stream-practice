package org.example.stream;


import org.example.Product;

import java.util.ArrayList;
import java.util.List;

/// Есть класс Product с полями name,
///  price, и category. Задача: отфильтровать все продукты,
///  у которых цена меньше 100, и которые принадлежат к категории "Electronics".
///  Вернуть список их названий в отсортированном порядке.
public class Number_1 {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 99.99, "Electronics"));
        products.add(new Product("Laptop", 1500.00, "Electronics"));
        products.add(new Product("Mouse", 25.00, "Home Appliances"));
        products.add(new Product("Keyboard", 45.50, "Electronics"));
        products.add(new Product("Headphones", 75.00, "Electronics"));
        products.add(new Product("Blender", 120.00, "Home Appliances"));
        products.add(new Product("Camera", 200.00, "Electronics"));
        products.add(new Product("Smartwatch", 90.00, "Electronics"));
        products.add(new Product("Tablet", 300.00, "Home Appliances"));
        products.add(new Product("Speaker", 85.00, "Electronics"));

        List<String> electronics = products.stream()
                .filter(product -> product.getPrice() < 100 && product.getCategory().equals("Electronics"))
                .map(Product::getName)
                .sorted((a, b) -> a.compareTo(b))
                .toList();

        System.out.println(electronics);

//        List<String> electronics = products.stream()
//                .filter(p -> p.getPrice() < 100 && p.getCategory().equals("Electronics"))
//                .map(Product::getName)
//                .sorted()
//                .toList();
//        System.out.println(electronics);

    }

}
