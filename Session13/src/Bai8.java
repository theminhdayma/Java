import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product8 {
    private String name;
    private double price;
    private int quantity;

    public Product8(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

public class Bai8 {
    private static final List<Product8> products = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Find Product by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> findProductByName();
                case 4 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        products.add(new Product8(name, price, quantity));
        System.out.println("Product added successfully!");
    }

    private static void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("\nList of Products:");
            products.forEach(System.out::println);
        }
    }

    private static void findProductByName() {
        System.out.print("Enter product name to search: ");
        String name = sc.nextLine();
        boolean found = false;

        for (Product8 product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Product found: " + product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
}
