import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thời gian ban đầu: ");
        System.out.println("giờ");
        int a = sc.nextInt();
        System.out.println("Phút");
        int b = sc.nextInt();
        System.out.println("giây");
        int c = sc.nextInt();

        System.out.println("Nhập thời gian cộng thêm: ");
        System.out.println("giờ");
        int x = sc.nextInt();
        System.out.println("Phút");
        int y = sc.nextInt();
        System.out.println("giây");
        int z = sc.nextInt();
        sc.close();

        int sum1 = a*3600 + b*60 + c;
        int sum2 = x*3600 + y*60 + z;
        int result = sum1 + sum2;

        int hour = result / 3600;
        int minute = result % 3600 / 60;
        int second = result % 60;

        System.out.printf("thời gian sau khi cộng thêm: %d:%02d:%02d", hour, minute, second);
    }
}
