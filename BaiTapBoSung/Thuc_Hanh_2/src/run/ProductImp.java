package run;

import entity.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductImp {
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> inputProducts(scanner);
                case 2 -> displayProducts();
                case 3 -> calculateProfit();
                case 4 -> sortProductsByProfit();
                case 5 -> filterProductsByPrice(scanner);
                case 6 -> searchProductByName(scanner);
                case 7 -> importProduct(scanner);
                case 8 -> sellProduct(scanner);
                case 9 -> updateProductStatus(scanner);
                case 10 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 10);
    }

    private static void inputProducts(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sản phẩm thứ " + (i + 1) + ":");
            Product product = new Product();
            product.inputData(scanner);
            products.add(product);
        }
    }

    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
        } else {
            products.forEach(Product::displayData);
        }
    }

    private static void calculateProfit() {
        products.forEach(Product::calProfit);
        System.out.println("Lợi nhuận đã được tính lại cho tất cả sản phẩm!");
    }

    private static void sortProductsByProfit() {
        products.sort(Comparator.comparing(Product::getProfit).reversed());
        System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận giảm dần!");
    }

    private static void filterProductsByPrice(Scanner scanner) {
        System.out.print("Nhập khoảng giá từ: ");
        float fromPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập khoảng giá đến: ");
        float toPrice = Float.parseFloat(scanner.nextLine());

        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getExportPrice() >= fromPrice && p.getExportPrice() <= toPrice)
                .toList();

        if (filteredProducts.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong khoảng giá này!");
        } else {
            filteredProducts.forEach(Product::displayData);
            System.out.println("Tổng số sản phẩm trong khoảng giá: " + filteredProducts.size());
        }
    }

    private static void searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine().toLowerCase();

        List<Product> foundProducts = products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(name))
                .toList();

        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào!");
        } else {
            foundProducts.forEach(Product::displayData);
        }
    }

    private static void importProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String id = scanner.nextLine();
        System.out.print("Nhập số lượng cần nhập: ");
        int qty = Integer.parseInt(scanner.nextLine());

        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                product.setQuantity(product.getQuantity() + qty);
                System.out.println("Đã nhập hàng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã này!");
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số lượng cần bán: ");
        int qty = Integer.parseInt(scanner.nextLine());

        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                if (!product.isStatus()) {
                    System.out.println("Sản phẩm này hiện tại không bán");
                    return;
                }
                if (product.getQuantity() >= qty) {
                    product.setQuantity(product.getQuantity() - qty);
                    System.out.println("Bán hàng thành công!");
                } else {
                    System.out.println("Không đủ hàng để bán!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm này!");
    }

    private static void updateProductStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String id = scanner.nextLine();

        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                product.setStatus(!product.isStatus());
                System.out.println("Đã cập nhật trạng thái sản phẩm!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã này!");
    }
}
