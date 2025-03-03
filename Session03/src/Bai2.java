import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();
        System.out.print("Nhập số nguyên c: ");
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("Ba số nguyên bằng nhau: " + a);
        } else {
            int max;
            if (a >= b && a >= c) {
                max = a;
            } else if (b >= a && b >= c) {
                max = b;
            } else {
                max = c;
            }

            System.out.println("Số lớn nhất là: " + max);
        }

        sc.close();
    }
}
