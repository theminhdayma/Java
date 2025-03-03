import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập điểm : ");
        double diemTB = sc.nextDouble();

        if (diemTB >= 8.5) {
            System.out.println("Xếp loại: Giỏi");
        } else if (diemTB >= 6.5) {
            System.out.println("Xếp loại: Khá");
        } else if (diemTB >= 5) {
            System.out.println("Xếp loại: Trung bình");
        } else {
            System.out.println("Xếp loại: Yếu");
        }
        sc.close();
    }
}
