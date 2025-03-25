package Bai9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product("Chuối", 1200),
                new Product("Táo", 25),
                new Product("Mít", 80),
                new Product("Dâu tây", 200),
                new Product("Sầu riêng", 50)
        );

        ProductProcessor processor = new ProductProcessorImpl();
        ProductProcessor.printProductList(productList);

        processor.hasExpensiveProduct(productList);

        double totalValue = processor.calculateTotalValue(productList);
        System.out.println("Tổng giá trị của danh sách sản phẩm: " + totalValue);
    }
}
