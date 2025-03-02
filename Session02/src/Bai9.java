import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = scanner.nextDouble();

        double perimeter = a + b + c;
        double p = perimeter / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        // Hiển thị kết quả
        System.out.printf("Chu vi: %.2f\n", perimeter);
        System.out.printf("Diện tích: %.2f\n", area);

        scanner.close();
    }
}
