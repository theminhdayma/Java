import java.math.BigInteger;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger num1 = getValidBigInteger(scanner, "Nhập số nguyên lớn thứ nhất: ");
        BigInteger num2 = getValidBigInteger(scanner, "Nhập số nguyên lớn thứ hai: ");

        System.out.println("Tổng: " + num1.add(num2));
        System.out.println("Hiệu: " + num1.subtract(num2));
        System.out.println("Tích: " + num1.multiply(num2));

        BigInteger exponent = getValidBigInteger(scanner, "Nhập số mũ (nguyên dương): ");
        if (exponent.signum() >= 0) {
            System.out.println("Lũy thừa: " + num1.pow(exponent.intValue()));
        } else {
            System.out.println("Số mũ không hợp lệ.");
        }

        if (num2.signum() != 0) {
            System.out.println("Thương: " + num1.divide(num2));
            System.out.println("Modulo: " + num1.mod(num2));
        } else {
            System.out.println("Không thể chia cho 0.");
        }
    }

    private static BigInteger getValidBigInteger(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return new BigInteger(input);
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu không hợp lệ. Vui lòng nhập lại một số nguyên lớn hợp lệ.");
            }
        }
    }
}
