import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập URL: ");
        String inputUrl = scanner.nextLine();

        String regex = "^(https?)://([a-zA-Z0-9.-]+)(:[0-9]+)?(/[^\\s]*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputUrl);

        if (matcher.matches()) {
            String protocol = matcher.group(1);
            String domain = matcher.group(2);
            String path = matcher.group(4) != null ? matcher.group(4) : "Không có đường dẫn.";

            System.out.println("Giao thức: " + protocol + "\n Tên miền: " + domain + "\n Đường dẫn: " + path);
        } else {
            System.out.println("URL không hợp lệ.");
        }

        scanner.close();
    }
}
