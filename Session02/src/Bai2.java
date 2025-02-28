import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập a: ");
        int a = sc.nextInt();

        System.out.print("Nhập b: ");
        int b = sc.nextInt();

        sc.close();

        int sum = a + b;
        int subtraction = a - b;
        int multiplication = a * b;
        int modulus = (b != 0) ? a % b : 0;

        if (b != 0) {
            int division = a / b;
            System.out.printf("%d / %d = %d%n", a, b, division);
        } else {
            System.out.println("Phép tính không chính xác");
        }

        // In kết quả
        System.out.printf("%d + %d = %d%n", a, b, sum);
        System.out.printf("%d - %d = %d%n", a, b, subtraction);
        System.out.printf("%d * %d = %d%n", a, b, multiplication);
        System.out.printf("%d %% %d = %d%n", a, b, modulus);

    }
}
