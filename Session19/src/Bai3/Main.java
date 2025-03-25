package Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        System.out.println("Kết quả phép cộng: " + MathOperations.add(a, b));
        System.out.println("Kết quả phép trừ: " + MathOperations.subtract(a, b));
        System.out.println("Kết quả phép nhân: " + MathOperations.multiply(a, b));
        System.out.println("Kết quả phép chia: " + MathOperations.divide(a, b));

        scanner.close();
    }
}
