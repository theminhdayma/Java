import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập 1 số nguyên dương : ");
        int n = sc.nextInt();
        int countPerfectNumber = 0;

        if (n > 1) {
            System.out.printf("Các số hoàn hảo nhỏ hơn " + n + " là:");
            for (int i = 2; i < n; i++) {
                int sum = 0;
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    System.out.printf("%d, ", sum);
                    countPerfectNumber ++;
                }
            }
            if (countPerfectNumber == 0) {
                System.out.printf("Không có số hoàn hảo nhỏ hơn " + n);
            }
        } else {
            System.out.println("Không có số hoàn hao nào nhỏ hơn 1 ");
        }

        sc.close();
    }
}
