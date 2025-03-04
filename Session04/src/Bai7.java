import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int N = sc.nextInt();

        if (N < 1) {
            System.out.println("Không hợp lệ, vui lòng nhập số nguyên dương.");
        } else {
            System.out.printf("Các số Happy nhỏ hơn hoặc bằng %d là: ", N);

            for (int i = 1; i <= N; i++) {
                int num = i;

                while (num != 1 && num != 4) {
                    int sum = 0;
                    int temp = num;

                    while (temp > 0) {
                        sum += (temp % 10) * (temp % 10);
                        temp /= 10;
                    }

                    num = sum;
                }

                if (num == 1) {
                    System.out.printf("%d\t", i);
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
