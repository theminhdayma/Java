import entity.Product;
import util.ProductFilter;

import java.util.*;

public class Main {
    private static final List<Product> productList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("************* MENU *************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayProducts();
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
                    searchProduct();
                    break;
                case 6:
                    filterProducts();
                    break;
                case 7:
                    sortProducts();
                    break;
                case 8:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1-8.");
            }
        } while (choice != 8);
    }

    private static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            productList.forEach(Product::displayData);
        }
    }

    private static void addProduct() {
        Product product = new Product();
        product.inputData(scanner);
        productList.add(product);
        System.out.println("Thêm sản phẩm thành công.");
    }

    private static void updateProduct() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Product> optionalProduct = productList.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst();

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            int choice;
            do {
                System.out.println("\nChọn thông tin cần cập nhật:");
                System.out.println("1. Tên sản phẩm");
                System.out.println("2. Giá sản phẩm");
                System.out.println("3. Danh mục sản phẩm");
                System.out.println("4. Thoát");
                System.out.print("Chọn: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        product.setProductName(scanner.nextLine());
                        System.out.println("Cập nhật tên sản phẩm thành công.");
                        break;
                    case 2:
                        System.out.print("Nhập giá mới: ");
                        while (!scanner.hasNextFloat()) {
                            System.out.println("Vui lòng nhập số hợp lệ!");
                            scanner.next();
                        }
                        product.setPrice(scanner.nextFloat());
                        scanner.nextLine();
                        System.out.println("Cập nhật giá sản phẩm thành công.");
                        break;
                    case 3:
                        System.out.print("Nhập danh mục mới: ");
                        product.setCategory(scanner.nextLine());
                        System.out.println("Cập nhật danh mục sản phẩm thành công.");
                        break;
                    case 4:
                        System.out.println("Cập nhật thành công.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1-5.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }


    private static void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (productList.removeIf(p -> p.getProductId() == id)) {
            System.out.println("Xóa sản phẩm thành công.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine().toLowerCase();

        List<Product> result = productList.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(name))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            result.forEach(Product::displayData);
        }
    }

    private static void filterProducts() {
        int choice;
        do {
            System.out.println("\n===== Chọn kiểu lọc =====");
            System.out.println("1. Lọc sản phẩm có giá lớn hơn X");
            System.out.println("2. Lọc sản phẩm theo danh mục");
            System.out.println("3. Thoát lọc");
            System.out.print("Chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập giá : ");
                    while (!scanner.hasNextFloat()) {
                        System.out.println("Vui lòng nhập số hợp lệ!");
                        scanner.next();
                    }
                    float price = scanner.nextFloat();
                    scanner.nextLine();
                    productList.stream()
                            .filter(p -> p.getPrice() > price)
                            .forEach(Product::displayData);
                    break;
                case 2:
                    System.out.print("Nhập danh mục: ");
                    String category = scanner.nextLine();
                    productList.stream()
                            .filter(p -> p.getCategory().equalsIgnoreCase(category))
                            .forEach(Product::displayData);
                    break;
                case 3:
                    System.out.println("Thoát lọc sản phẩm.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");

            }
        } while (choice != 3);
    }

    private static void sortProducts() {
        int choice;
        do {
            System.out.println("\n===== Chọn kiểu sắp xếp =====");
            System.out.println("1. Sắp xếp tăng dần theo giá");
            System.out.println("2. Sắp xếp giảm dần theo giá");
            System.out.println("3. Thoát sắp xếp");
            System.out.print("Nhập lựa chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            List<Product> sortedList = new ArrayList<>(productList);

            switch (choice) {
                case 1:
                    sortedList.sort(Comparator.comparing(Product::getPrice));
                    System.out.println("Danh sách sản phẩm sau khi sắp xếp tăng dần:");
                    sortedList.forEach(Product::displayData);
                    break;
                case 2:
                    sortedList.sort(Comparator.comparing(Product::getPrice).reversed());
                    System.out.println("Danh sách sản phẩm sau khi sắp xếp giảm dần:");
                    sortedList.forEach(Product::displayData);
                    break;
                case 3:
                    System.out.println("Thoát sắp xếp sản phẩm.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        } while (choice != 3);
    }
}
