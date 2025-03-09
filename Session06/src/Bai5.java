import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi:");
        String input = sc.nextLine();
        sc.close();

        Pattern pattern = Pattern.compile("\\b\\S*[!@#$%^&*()_+=\\-\\[\\]{};:'\",.<>?/\\\\|`~]+\\S*\\b");
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        String result = "";

        while (matcher.find()) {
            if (count > 0) {
                result += ", ";
            }
            result += matcher.group();
            count++;
        }

        if (count == 0) {
            System.out.println("0 (Không có ký tự đặc biệt)");
        } else {
            System.out.println(count + " (" + result + ")");
        }
    }
}
