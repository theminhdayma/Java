import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}

public class Bai5 {
    private static final List<Product> products = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int productIdCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Find Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAllProducts();
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Product product = new Product(productIdCounter++, name, price);
        products.add(product);
        System.out.println("Product added successfully!");
    }

    private static void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\nProduct List:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void findProduct() {
        System.out.print("Enter product name to find: ");
        String name = sc.nextLine();
        boolean found = false;

        for (Product product : products) {
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
