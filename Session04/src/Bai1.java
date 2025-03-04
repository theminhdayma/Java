import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập 1 số nguyên dương : ");
        int N = sc.nextInt();

        if (N > 0) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.printf("Tổng các số từ 1 đến %d: %d\n", N, sum);
        } else {
            System.out.println("Số nhập vào không hợp lệ");
        }

        sc.close();
    }
}
