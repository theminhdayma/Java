import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập mật khẩu cần kiểm tra:");
        String password = scanner.nextLine();
        scanner.close();

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-\\[\\]{};:'\",.<>?/\\\\|`~]).{8,}$";

        if (password.matches(regex)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }
    }
}
