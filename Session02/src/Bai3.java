import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập x: ");
        int x = sc.nextInt();

        System.out.print("Nhập y: ");
        int y = sc.nextInt();

        boolean isEqual = (x == y);
        boolean isNotEqual = (x != y);
        boolean isGreater = (x > y);
        boolean isLess = (x < y);
        boolean isGreaterOrEqual = (x >= y);
        boolean isLessOrEqual = (x <= y);

        System.out.println("x == y: " + isEqual);
        System.out.println("x != y: " + isNotEqual);
        System.out.println("x > y: " + isGreater);
        System.out.println("x < y: " + isLess);
        System.out.println("x >= y: " + isGreaterOrEqual);
        System.out.println("x <= y: " + isLessOrEqual);

        if (isGreater) {
            System.out.println("x lớn hơn y");
        } else if (isLess) {
            System.out.println("x nhỏ hơn y");
        } else {
            System.out.println("x bằng y");
        }

        System.out.print("Nhập số thực a: ");
        double a = sc.nextDouble();

        System.out.print("Nhập số thực b: ");
        double b = sc.nextDouble();

        if (a > b) {
            System.out.println("a lớn hơn b");
        } else if (a < b) {
            System.out.println("a nhỏ hơn b");
        } else {
            System.out.println("a bằng b");
        }

        sc.nextLine();

        System.out.print("Nhập chuỗi thứ nhất: ");
        String str1 = sc.nextLine();

        System.out.print("Nhập chuỗi thứ hai: ");
        String str2 = sc.nextLine();

        if (str1.equals(str2)) {
            System.out.println("Hai chuỗi bằng nhau");
        } else {
            System.out.println("Hai chuỗi khác nhau");
        }

        sc.close();
    }
}
