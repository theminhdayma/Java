import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng số điện thoại: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] phoneNumbers = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số điện thoại thứ " + (i + 1) + ": ");
            phoneNumbers[i] = scanner.nextLine();
        }

        System.out.println("Kết quả sau khi chuẩn hóa:");

        for (int i = 0; i < n; i++) {
            String phone = phoneNumbers[i];

            phone = phone.replaceAll("[.\\-]", " "); // Thay dấu '.' và '-' thành khoảng trắng
            phone = phone.replaceAll("\\s+", " ").trim(); // Loại bỏ khoảng trắng dư thừa

            String regexVNPhone = "^(0[1-9]\\d{8}|\\+84[1-9]\\d{8})$";
            if (!Pattern.matches(regexVNPhone, phone.replaceAll(" ", ""))) {
                System.out.println("Số điện thoại không hợp lệ");
                continue;
            }

            if (phone.startsWith("0")) {
                phone = "+84 " + phone.substring(1);
            }

            System.out.println(phone);
        }

        scanner.close();
    }
}
