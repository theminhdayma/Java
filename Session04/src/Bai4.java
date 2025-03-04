import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int sum = 0;

        System.out.println("Nhập các số nguyên");
        while (true) {
            System.out.print("Nhập số: ");
            n = sc.nextInt();

            if (n == 0) {
                break;
            }

            sum += n;
        }

        System.out.println("Tổng các số đã nhập: " + sum);

        sc.close();
    }
}
