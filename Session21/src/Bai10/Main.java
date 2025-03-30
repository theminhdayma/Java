package Bai10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        Product[] products = {
                new Product("P001", "Áo", 150000),
                new Product("P002", "Quần", 300000),
                new Product("P003", "Giày", 700000)
        };

        while (true) {
            System.out.println("\n===============MENU===============");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice;
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Danh sách sản phẩm có sẵn:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String productId = scanner.nextLine();
                    Product selectedProduct = null;
                    for (Product p : products) {
                        if (p.getId().equalsIgnoreCase(productId)) {
                            selectedProduct = p;
                            break;
                        }
                    }
                    if (selectedProduct == null) {
                        System.out.println("Sản phẩm không tồn tại!");
                        break;
                    }
                    try {
                        System.out.print("Nhập số lượng: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        cart.addToCart(selectedProduct, quantity);
                    } catch (InvalidQuantityException | NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    try {
                        cart.removeFromCart(scanner.nextLine());
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lỗi: Chọn số từ 1 đến 6!");
            }
        }
    }
}
