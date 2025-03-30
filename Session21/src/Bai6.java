import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;

        System.out.println("Nhập danh sách các chuỗi (cách nhau bởi dấu phẩy): ");
        String input = sc.nextLine();

        String[] tokens = input.split(",");

        for (String token : tokens) {
            token = token.trim();

            try {
                int number = Integer.parseInt(token);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ");
                invalidCount++;
            }
        }

        System.out.println("Số lượng chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("Số lượng chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);

        sc.close();
    }
}
