import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int N = sc.nextInt();

        if (N < 0) {
            System.out.println("Số không hợp lệ");
        } else {
            System.out.printf("Các số Armstrong nhỏ hơn hoặc bằng %d là: ", N);
            boolean isFirst = true;

            for (int i = 0; i <= N; i++) {
                int num = i, sum = 0, count = 0;

                int temp = num;
                while (temp > 0) {
                    count++;
                    temp /= 10;
                }
                if (num == 0) count = 1;

                temp = num;
                while (temp > 0) {
                    int digit = temp % 10;
                    int power = 1;
                    for (int j = 1; j <= count; j++) {
                        power *= digit;
                    }
                    sum += power;
                    temp /= 10;
                }

                if (sum == num) {
                    System.out.printf("%d\t", num);
                }
            }
        }
    }
}
