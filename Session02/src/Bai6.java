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

        double avg = (math + physics + chemistry) / 3;
        String result = (avg >= 5.0) ? "Lên lớp" : "Học lại";

        System.out.printf("Tên học sinh: %s\n", name);
        System.out.printf("Điểm Toán: %.2f | Điểm Lý: %.2f | Điểm Hóa: %.2f\n", math, physics, chemistry);
        System.out.printf("Điểm trung bình: %.2f\n", avg);
        System.out.println("Đánh giá: " + result);
    }
}
