import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập danh sách số điện thoại (cách nhau bằng dấu phẩy): ");
        String input = scanner.nextLine();

        String[] phoneNumbers = input.split(",");

        for (String phoneNumber : phoneNumbers) {
            phoneNumber = phoneNumber.trim().replaceAll("[ .-]", "");

            if (phoneNumber.matches("0\\d{9}")) {
                phoneNumber = "+84" + phoneNumber.substring(1);
            } else if (!phoneNumber.matches("\\+849\\d{8}")) {
                System.out.println("\"" + phoneNumber + "\" không phải là số điện thoại hợp lệ.");
                continue;
            }

            phoneNumber = phoneNumber.replaceAll("(\\+84)(\\d{3})(\\d{3})(\\d{3})", "$1 $2 $3 $4");
            System.out.println("Số điện thoại chuẩn hóa: " + phoneNumber);
        }
    }
}