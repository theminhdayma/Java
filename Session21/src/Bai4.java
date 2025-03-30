import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập vào 1 số: ");
            int n = sc.nextInt();
            System.out.println("Bạn đã nhập " + n);
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số nguyên");
        } finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
            sc.close();
        }
    }
}
