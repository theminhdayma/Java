package entity_ChatGPT;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class ProductManager {
    private final List<Product> products = new ArrayList<>();

    public void manage(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n****** QUẢN LÝ SẢN PHẨM ******");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Quay lại");
            System.out.print("Chọn chức năng: ");
            choice = ShopManagement.getValidIntInput();

            switch (choice) {
                case 1 -> listProducts();
                case 2 -> addProduct(scanner);
                case 3 -> updateProduct(scanner);
                case 4 -> deleteProduct(scanner);
                case 5 -> searchProduct(scanner);
                case 6 -> System.out.println("Quay lại menu chính.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private void listProducts() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
            return;
        }
        System.out.println("\nDanh sách sản phẩm:");
        products.forEach(Product::displayData);
    }

    private void addProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        products.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();

        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.print("Nhập tên sản phẩm mới: ");
                product.setName(scanner.nextLine());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
    }

    private void deleteProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = scanner.nextLine();

        if (products.removeIf(product -> product.getId().equals(id))) {
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private void searchProduct(Scanner scanner) {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword))
                .forEach(Product::displayData);
    }
}

