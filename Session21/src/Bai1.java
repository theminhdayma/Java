import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập vào số nguyên a: ");
            int a = sc.nextInt();
            System.out.print("Nhập vào số nguyên b: ");
            int b = sc.nextInt();

            if (b == 0) {
                throw new ArithmeticException("Không thể chia cho 0!");
            }

            double divisor = (double) a / b;
            System.out.println("Kết quả phép chia: " + divisor);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
