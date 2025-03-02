import java.math.BigInteger;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên lớn a: ");
        BigInteger a = new BigInteger(scanner.nextLine());

        System.out.print("Nhập số nguyên lớn b: ");
        BigInteger b = new BigInteger(scanner.nextLine());

        BigInteger sum = a.add(b);
        BigInteger difference = a.subtract(b);
        BigInteger product = a.multiply(b);
        BigInteger quotient = a.divide(b);
        BigInteger remainder = a.mod(b);
        BigInteger power = a.pow(10);

        System.out.println("a + b = " + sum);
        System.out.println("a - b = " + difference);
        System.out.println("a * b = " + product);
        System.out.println("a / b = " + quotient);
        System.out.println("a % b = " + remainder);
        System.out.println("a^10 = " + power);

        scanner.close();
    }
}
