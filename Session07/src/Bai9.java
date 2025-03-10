import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String word = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                sb.append(word.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        System.out.println("Chuỗi đã nén: " + sb);
    }
}