package entity_ChatGPT;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class CategoryManager {
    private final List<String> categories = new ArrayList<>();

    public void manage(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n****** QUẢN LÝ DANH MỤC ******");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục");
            System.out.println("6. Quay lại");
            System.out.print("Chọn chức năng: ");
            choice = ShopManagement.getValidIntInput();

            switch (choice) {
                case 1 -> listCategories();
                case 2 -> addCategory(scanner);
                case 3 -> updateCategory(scanner);
                case 4 -> deleteCategory(scanner);
                case 5 -> searchCategory(scanner);
                case 6 -> System.out.println("Quay lại menu chính.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private void listCategories() {
        if (categories.isEmpty()) {
            System.out.println("Không có danh mục nào.");
            return;
        }
        System.out.println("Danh sách danh mục:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
    }

    private void addCategory(Scanner scanner) {
        System.out.print("Nhập tên danh mục: ");
        categories.add(scanner.nextLine().trim());
        System.out.println("Thêm danh mục thành công!");
    }

    private void updateCategory(Scanner scanner) {
        listCategories();
        System.out.print("Nhập số danh mục cần cập nhật: ");
        int index = ShopManagement.getValidIntInput() - 1;

        if (isValidIndex(index, categories.size())) {
            System.out.print("Nhập tên mới: ");
            categories.set(index, scanner.nextLine().trim());
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Số danh mục không hợp lệ!");
        }
    }

    private void deleteCategory(Scanner scanner) {
        listCategories();
        System.out.print("Nhập số danh mục cần xóa: ");
        int index = ShopManagement.getValidIntInput() - 1;

        if (isValidIndex(index, categories.size())) {
            categories.remove(index);
            System.out.println("Xóa danh mục thành công!");
        } else {
            System.out.println("Số danh mục không hợp lệ!");
        }
    }

    private void searchCategory(Scanner scanner) {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).toLowerCase().contains(keyword)) {
                System.out.println((i + 1) + ". " + categories.get(i));
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy danh mục phù hợp.");
    }

    private boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}
