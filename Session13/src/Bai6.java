import java.util.ArrayList;
import java.util.List;

class Products {
    private String name;
    private double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class Bai6 {
    private static final double TAX_RATE = 0.1;

    public static void main(String[] args) {
        List<Products> products = new ArrayList<>();
        products.add(new Products("Product 1", 100));
        products.add(new Products("Product 2", 200));
        products.add(new Products("Product 3", 300));

        printInvoice(products);
    }

    private static double calculateTotal(List<Products> products) {
        double total = 0;
        for (Products product : products) {
            total += product.getPrice();
        }
        return total;
    }

    private static double calculateTax(double total) {
        return total * TAX_RATE;
    }

    private static double calculateFinalAmount(double total, double tax) {
        return total + tax;
    }

    private static void printInvoice(List<Products> products) {
        System.out.println("+----------------+--------+");
        System.out.println("| Product Name   | Price  |");
        System.out.println("+----------------+--------+");

        for (Products product : products) {
            System.out.printf("| %-14s | $%-5.2f |\n", product.getName(), product.getPrice());
        }

        double total = calculateTotal(products);
        double tax = calculateTax(total);
        double finalAmount = calculateFinalAmount(total, tax);

        System.out.println("+----------------+--------+");
        System.out.printf("| %-14s | $%-5.2f |\n", "Total", total);
        System.out.printf("| %-14s | $%-5.2f |\n", "Tax (10%)", tax);
        System.out.printf("| %-14s | $%-5.2f |\n", "Final Amount", finalAmount);
        System.out.println("+----------------+--------+");
    }
}
