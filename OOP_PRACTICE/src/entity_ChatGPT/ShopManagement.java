package entity_ChatGPT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CategoryManager categoryManager = new CategoryManager();
    private static final ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n********** SHOP MENU **********");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = getValidIntInput();

            switch (choice) {
                case 1 -> categoryManager.manage(scanner);
                case 2 -> productManager.manage(scanner);
                case 3 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }

    // Hàm hỗ trợ nhập số nguyên hợp lệ
    private static int getValidIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Vui lòng nhập số hợp lệ: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return value;
    }
}
