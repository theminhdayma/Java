import java.sql.SQLOutput;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();
        checkAge(age);
    }

    private static void checkAge(int age) {
        try {
            if (age > 18) {
                System.out.println("Chào mừng bạn");
            } else {
                throw new ArithmeticException("Bạn chưa đủ 18 tuổi");
            }
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
