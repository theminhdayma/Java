import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int N = sc.nextInt();

        if (N < 1) {
            System.out.println("Số không hợp lệ!");
        } else {
            System.out.printf("Các số Palindrome từ 1 đến " + N + " là:");
            for (int i = 1; i <= N; i++) {
                int num = i;
                int reversed = 0;

                while (num > 0) {
                    int digit = num % 10;
                    reversed = reversed * 10 + digit;
                    num /= 10;
                }

                if (i == reversed) {
                    System.out.printf("%d\t", i);
                }
            }
        }
        sc.close();
    }
}
