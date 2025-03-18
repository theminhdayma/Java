package entity_ChatGPT;
import java.util.Scanner;

public class ShopManagement {
    private static final int MAX_CATEGORY = 100;
    private static final int MAX_PRODUCT = 100;
    private static Categories[] categories = new Categories[MAX_CATEGORY];
    private static Product[] products = new Product[MAX_PRODUCT];
    private static int categoryCount = 0;
    private static int productCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageCategories(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }

    private static void manageCategories(Scanner scanner) {
        int choice;
        do {
            System.out.println("********************CATEGORIE MANAGEMENT*********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listCategories();
                    break;
                case 2:
                    addCategory(scanner);
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
                    break;
                case 5:
                    searchCategory(scanner);
                    break;
                case 6:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private static void listCategories() {
        if (categoryCount == 0) {
            System.out.println("Không có danh mục nào.");
            return;
        }
        System.out.println("Danh sách danh mục:");
        for (int i = 0; i < categoryCount; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
    }

    private static void addCategory(Scanner scanner) {
        if (categoryCount >= MAX_CATEGORY) {
            System.out.println("Không thể thêm danh mục mới!");
            return;
        }

        Categories category = new Categories();
        category.inputData(scanner);
        categories[categoryCount++] = category;

        System.out.println("Thêm danh mục thành công!");
    }

    private static void updateCategory(Scanner scanner) {
        System.out.print("Nhập ID danh mục cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId() == id) {
                int choice;
                do {
                    System.out.println("1. Tên danh mục");
                    System.out.println("2. Độ ưu tiên");
                    System.out.println("3. Mô tả");
                    System.out.println("4. Trạng thái");
                    System.out.println("5. Thoát");
                    System.out.print("Nhập lựa chọn của bạn: ");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập tên danh mục mới: ");
                            categories[i].setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập độ ưu tiên mới: ");
                            categories[i].setPriority(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Nhập mô tả mới: ");
                            categories[i].setDescription(scanner.nextLine());
                            scanner.nextLine();
                            break;
                        case 4:
                            System.out.print("Nhập trạng thái mới (True: Hoạt động, False: Không hoạt động): ");
                            categories[i].setStatus(scanner.nextBoolean());
                            break;
                        case 5:
                            System.out.println("Cập nhật thành công !!!.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    }

                } while (choice != 5);

                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm!");
    }

    private static void deleteCategory(Scanner scanner) {
        listCategories();
        System.out.print("Nhập số danh mục cần xóa: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < categoryCount) {
            categories[index] = categories[categoryCount - 1];
            categoryCount--;
            System.out.println("Xóa danh mục thành công!");
        } else {
            System.out.println("Số danh mục không hợp lệ!");
        }
    }

    private static void searchCategory(Scanner scanner) {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        System.out.println("Kết quả tìm kiếm:");
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getName().toLowerCase().contains(keyword)) {
                System.out.println((i + 1) + ". " + categories[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy danh mục nào chứa từ khóa: " + keyword);
        }
    }


    private static void manageProducts(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************************ PRODUCT MANAGEMENT *******************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
            System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
            System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    searchProductByPrice(scanner);
                    break;
                case 7:
                    sortProductsByPrice();
                    break;
                case 8:
                    sellProduct(scanner);
                    break;
                case 9:
                    countProductsByCategory(products, productCount);
                    break;
                case 10:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 10);
    }

    private static void listProducts() {
        if (productCount == 0) {
            System.out.println("Không có sản phẩm nào.");
            return;
        }
        System.out.println("\nDanh sách sản phẩm:");
        for (int i = 0; i < productCount; i++) {
            products[i].displayData();
        }
    }

    private static void addProduct(Scanner scanner) {
        if (productCount >= MAX_PRODUCT) {
            System.out.println("Không thể thêm sản phẩm mới!");
            return;
        }
        Product product = new Product();
        product.inputData(scanner);
        products[productCount++] = product;
        System.out.println("Thêm sản phẩm thành công!");
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                int choice;
                do {
                    System.out.println("1. Tên sản phẩm");
                    System.out.println("2. Giá nhập");
                    System.out.println("3. Giá xuất");
                    System.out.println("4. Tiêu đề");
                    System.out.println("5. Mô tả");
                    System.out.println("6. Số lượng");
                    System.out.println("7. Mã danh mục");
                    System.out.println("8. Trạng thái");
                    System.out.println("0. Thoát");
                    System.out.print("Nhập lựa chọn của bạn: ");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập tên sản phẩm mới: ");
                            products[i].setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập giá nhập mới: ");
                            products[i].setImportPrice(scanner.nextFloat());
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Nhập giá xuất mới: ");
                            products[i].setExportPrice(scanner.nextFloat());
                            scanner.nextLine();
                            break;
                        case 4:
                            System.out.print("Nhập tiêu đề mới: ");
                            products[i].setTitle(scanner.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhập mô tả mới: ");
                            products[i].setDescription(scanner.nextLine());
                            break;
                        case 6:
                            System.out.print("Nhập số lượng mới: ");
                            products[i].setQuantity(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 7:
                            System.out.print("Nhập mã danh mục mới: ");
                            products[i].setCategoryId(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 8:
                            System.out.print("Nhập trạng thái mới (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
                            products[i].setStatus(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 9:
                            System.out.println("Cập nhật thành công !!!.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    }

                } while (choice != 9);

                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm!");
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--productCount] = null;
                System.out.println("Xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("Nhập tên hoặc tiêu đề sản phẩm: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().contains(keyword)) {
                products[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    private static void searchProductByPrice(Scanner scanner) {
        System.out.print("Nhập giá thấp nhất: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Nhập giá cao nhất: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getExportPrice() >= minPrice && products[i].getExportPrice() <= maxPrice) {
                products[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có sản phẩm nào trong khoảng giá này!");
        }
    }

    private static void sortProductsByPrice() {
        if (productCount == 0) {
            System.out.println("Không có sản phẩm để sắp xếp.");
            return;
        }

        // Sử dụng Bubble Sort để sắp xếp giá tăng dần
        for (int i = 0; i < productCount - 1; i++) {
            for (int j = 0; j < productCount - i - 1; j++) {
                if (products[j].getExportPrice() > products[j + 1].getExportPrice()) {
                    // Hoán đổi vị trí
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }

        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo giá tăng dần:");
        listProducts();
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần bán: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                System.out.print("Nhập số lượng bán: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng thừa

                if (products[i].getQuantity() >= quantity) {
                    products[i].setQuantity(products[i].getQuantity() - quantity);
                    System.out.println("Bán sản phẩm thành công!");
                } else {
                    System.out.println("Không đủ hàng trong kho!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }


    private static void countProductsByCategory(Product[] products, int productCount) {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        int[] categoryIds = new int[productCount];
        int categoryCount = 0;

        for (int i = 0; i < productCount; i++) {
            int categoryId = products[i].getCategoryId();
            boolean exists = false;

            for (int j = 0; j < categoryCount; j++) {
                if (categoryIds[j] == categoryId) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                categoryIds[categoryCount++] = categoryId;
            }
        }

        for (int i = 0; i < categoryCount; i++) {
            int categoryId = categoryIds[i];
            int count = 0;

            for (int j = 0; j < productCount; j++) {
                if (products[j].getCategoryId() == categoryId) {
                    count++;
                }
            }

            System.out.println("Danh mục ID: " + categoryId + " - Số lượng sản phẩm: " + count);
        }
    }

}
