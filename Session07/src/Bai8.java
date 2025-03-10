import java.util.Random;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài chuỗi: ");
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int type = random.nextInt(3);
            if (type == 0) {
                sb.append((char) ('A' + random.nextInt(26)));
            } else if (type == 1) {
                sb.append((char) ('a' + random.nextInt(26)));
            } else {
                sb.append((char) ('0' + random.nextInt(10)));
            }
        }

        System.out.println("Chuỗi ngẫu nhiên: " + sb);
    }
}