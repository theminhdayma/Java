package entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Product implements IProduct {
    private static int count = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.productId = count++;
    }

    public Product(String productName, float price, String category) {
        this.productId = count++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.createdDate = LocalDate.now();
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        while (this.productName.length() < 30 || this.productName.length() > 100) {
            System.out.print("Tên không hợp lệ, nhập lại: ");
            this.productName = scanner.nextLine();
        }

        System.out.print("Nhập giá sản phẩm: ");
        while (!scanner.hasNextFloat() || (this.price = scanner.nextFloat()) <= 0) {
            System.out.print("Giá không hợp lệ, nhập lại: ");
            scanner.next();
        }
        scanner.nextLine();

        System.out.print("Nhập danh mục sản phẩm: ");
        this.category = scanner.nextLine();

        this.createdDate = LocalDate.now();
    }

    @Override
    public void displayData() {
        System.out.println("---------------------------");
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá sản phẩm: " + this.price);
        System.out.println("Danh mục: " + this.category);
        System.out.println("Ngày tạo: " + this.createdDate);
    }
}
