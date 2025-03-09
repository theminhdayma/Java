import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập địa chỉ email:");
        String email = sc.nextLine().trim();
        sc.close();

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (pattern.matcher(email).matches()) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }
}
