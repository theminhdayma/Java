import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chiều dài : ");
        int a = sc.nextInt();

        System.out.print("Nhập chiều rộng : ");
        int b = sc.nextInt();

        sc.close();

        System.out.printf("Diện tích hình chữ nhật là: %d\n", a * b);
        System.out.printf("Chu vi hình chữ nhật là: %d\n", 2 * (a + b));
    }
}
