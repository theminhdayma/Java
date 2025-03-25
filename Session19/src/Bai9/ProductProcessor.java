package Bai9;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface ProductProcessor {
    abstract double calculateTotalValue(List<Product> products);

    default void hasExpensiveProduct(List<Product> products) {
        Predicate<Product> isExpensive = p -> p.getPrice() > 100;
        List<Product> expensiveProducts = products.stream().filter(isExpensive).collect(Collectors.toList());

        if (expensiveProducts.isEmpty()) {
            System.out.println("Không có sản phẩm đắt tiền");
        } else {
            System.out.println("Các sản phẩm đắt tiền:");
            expensiveProducts.forEach(System.out::println);
        }
    }

    static void printProductList(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        products.forEach(System.out::println);
    }
}
