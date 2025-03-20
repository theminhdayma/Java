import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();
        System.out.println("Nhập các số nguyên:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> primeNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            } else {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }
            }
        }

        System.out.println("Số nguyên tố: " + primeNumbers);
        System.out.println("Số chẵn: " + evenNumbers);
        System.out.println("Số lẻ: " + oddNumbers);

        scanner.close();
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
