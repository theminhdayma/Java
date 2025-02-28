import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên học sinh");
        String name = sc.nextLine();
        System.out.println("Nhâp điểm môn toán");
        double math = sc.nextDouble();
        System.out.println("Nhập điểm môn lý");
        double physics = sc.nextDouble();
        System.out.println("Nhập điểm môn hóa");
        double chemistry = sc.nextDouble();

        sc.close();

        double resultavg = (math + physics + chemistry) / 3;
        String result;

        if (resultavg >8.0) {
            result = "giỏi";
        } else if (resultavg > 6.5) {
            result = "khá";
        } else if (resultavg > 5.0) {
            result = "Trung bình";
        } else {
            result = "Yếu";
        }

        System.out.printf("Tên học sinh: %s\n Điểm trung bình: %f\n Xếp loại: %s\n", name, resultavg, result);
    }
}
