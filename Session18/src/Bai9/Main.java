package Bai9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Product> productMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== MENU SẢN PHẨM ===");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tính tổng giá trị kho");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    calculateTotalInventoryValue();
                    break;
                case 6:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 6!");
            }
        } while (choice != 6);
    }

    private static void addProduct() {
        Product product = new Product();
        product.inputData();

        if (productMap.containsKey(product.getId())) {
            System.out.println("ID sản phẩm đã tồn tại! Vui lòng nhập lại.");
            return;
        }

        productMap.put(product.getId(), product);
        System.out.println("Sản phẩm đã được thêm thành công!");
    }

    private static void updateProduct() {
        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!productMap.containsKey(id)) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        Product product = productMap.get(id);

        int choice;
        do {
            System.out.println("\n--- CHỈNH SỬA SẢN PHẨM ---");
            System.out.println("1. Sửa giá sản phẩm");
            System.out.println("2. Sửa số lượng sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double newPrice;
                    do {
                        System.out.print("Nhập giá mới: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Giá phải là số hợp lệ!");
                            scanner.next();
                        }
                        newPrice = scanner.nextDouble();
                        if (newPrice < 0) {
                            System.out.println("Giá không thể âm! Vui lòng nhập lại.");
                        }
                    } while (newPrice < 0);
                    product.setPrice(newPrice);
                    break;

                case 2:
                    int newQuantity;
                    do {
                        System.out.print("Nhập số lượng mới: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Số lượng phải là số nguyên!");
                            scanner.next();
                        }
                        newQuantity = scanner.nextInt();
                        if (newQuantity < 0) {
                            System.out.println("Số lượng không thể âm! Vui lòng nhập lại.");
                        }
                    } while (newQuantity < 0);
                    product.setQuantity(newQuantity);
                    break;

                case 3:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1 đến 3.");
            }
        } while (choice != 3);

        productMap.put(id, product);
        System.out.println("Cập nhật sản phẩm thành công!");
    }


    private static void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = scanner.nextInt();

        if (productMap.remove(id) != null) {
            System.out.println("Sản phẩm đã được xóa thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    private static void showAllProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        System.out.println("\n=== Danh sách sản phẩm ===");
        for (Product product : productMap.values()) {
            product.displayData();
        }
    }

    private static void calculateTotalInventoryValue() {
        double totalValue = 0;
        for (Product product : productMap.values()) {
            totalValue += product.totalPrice();
        }
        System.out.println("Tổng giá trị kho: " + totalValue);
    }
}