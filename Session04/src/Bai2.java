import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập 1 số nguyên dương : ");
        int N = sc.nextInt();

        if (N < 2) {
            System.out.println("Không phải số nguyên tố");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    isPrime = false;
                    System.out.printf("%d không phải số nguyên tố", N);
                    break;
                }
            }
            if (isPrime) {
                System.out.println(N + " là số nguyên tố.");
            } else {
                System.out.println(N + " không phải số nguyên tố.");
            }
        }

        sc.close();
    }
}
