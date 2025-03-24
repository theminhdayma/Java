package Bai9;

import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product() {}

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double totalPrice() {
        return price * quantity;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID sản phẩm: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        do {
            System.out.print("Nhập tên sản phẩm: ");
            this.name = scanner.nextLine();
            if (this.name.trim().isEmpty()) {
                System.out.println("Tên sản phẩm không được để trống. Vui lòng nhập lại!");
            }
        } while (this.name.trim().isEmpty());

        do {
            System.out.print("Nhập giá sản phẩm: ");
            this.price = scanner.nextDouble();
            if (this.price < 0) {
                System.out.println("Giá không thể âm. Vui lòng nhập lại!");
            }
        } while (this.price < 0);

        do {
            System.out.print("Nhập số lượng sản phẩm: ");
            this.quantity = scanner.nextInt();
            if (this.quantity < 0) {
                System.out.println("Số lượng không thể âm. Vui lòng nhập lại!");
            }
        } while (this.quantity < 0);
    }

    public void displayData() {
        System.out.println("------------------------------");
        System.out.println("ID: " + this.id);
        System.out.println("Tên sản phẩm: " + this.name);
        System.out.println("Giá sản phâm: " + this.price);
        System.out.println("Số lượng: " + this.quantity);
    }
}
