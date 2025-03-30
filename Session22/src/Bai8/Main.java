package Bai8;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "products.dat";

        List<Product> products = Arrays.asList(
                new Product(1, "Chuối", 100),
                new Product(2, "Táo", 800),
                new Product(3, "Cam", 200),
                new Product(4, "Sầu riêng", 400),
                new Product(5, "Dâu tây", 500)
        );

        writeProductsToFile(filePath, products);

        List<Product> readProducts = readProductsFromFile(filePath);
        printProducts(readProducts);
    }

    private static void writeProductsToFile(String filePath, List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(products);
            System.out.println("Danh sách sản phẩm đã được ghi vào file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Product> readProductsFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static void printProducts(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

