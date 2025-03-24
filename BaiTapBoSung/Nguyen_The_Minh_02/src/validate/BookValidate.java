package validate;

import java.util.Scanner;

public class BookValidate {

    public static String validateInputString(Scanner scanner, String message, StringRule rule) {
        System.out.println(message);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Không được để trống, vui lòng nhập lại.");
                continue;
            }
            if (rule.isValidString(input)) {
                return input;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại.");
        }
    }

    public static int validateInputInt(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.err.println("Không phải số nguyên hợp lệ, vui lòng nhập lại.");
                scanner.next();
            }
        }
    }

    public static double validateInputDouble(Scanner scanner, String message, double minValue) {
        System.out.println(message);
        while (true) {
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                if (number > minValue) {
                    return number;
                }
                System.err.printf("Giá trị phải lớn hơn %.2f, vui lòng nhập lại.%n", minValue);
            } else {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại.");
                scanner.next();
            }
        }
    }
}
