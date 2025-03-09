import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);

        System.out.println("Nhập email");
        String email = scanner.nextLine();

        if (pattern.matcher(email).matches()) {
            String[] parts = email.split("@");
            String userName = parts[0];
            String domain = parts[1];

            System.out.println("Tên người dùng: " + userName + ", Tên miền: " + domain);
        } else {
            System.out.println("Email không hợp lệ");
        }

        scanner.close();
    }
}
