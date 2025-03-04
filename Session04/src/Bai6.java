import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập 1 số nguyên : ");
        int N = sc.nextInt();
        int sum = 0;

        if (N < 0) {
            N = -N;
        }

        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }

        System.out.println("Tổng các chữ số: " + sum);

        sc.close();
    }
}
