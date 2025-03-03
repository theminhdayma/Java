import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập cạnh thứ nhất: ");
        int a = sc.nextInt();

        System.out.print("Nhập cạnh thứ hai: ");
        int b = sc.nextInt();

        System.out.print("Nhập cạnh thứ ba: ");
        int c = sc.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Ba cạnh tạo thành một tam giác.");

            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều.");
            } else if (a == b || a == c || b == c) {
                System.out.println("Đây là tam giác cân.");
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("Đây là tam giác vuông.");
            } else {
                System.out.println("Đây là tam giác thường.");
            }
        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        sc.close();
    }
}
