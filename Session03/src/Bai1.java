import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập 1 số nguyên: ");
        int a = sc.nextInt();

        if (a % 2 == 0) {
            System.out.println("Số chẵn");
        } else if (a % 2 == 1) {
            System.out.println("Số lẻ");
        } else {
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        }

        sc.close();
    }
}
