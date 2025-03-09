import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi bất kỳ:");
        String str1 = sc.nextLine().trim();
        System.out.println("Nhập chuỗi con: ");
        String str2 = sc.nextLine().trim();
        sc.close();

        int position = str1.indexOf(str2);
        if (position != -1) {
            System.out.printf("Từ %s xuất hiệnở vị trí %d", str2, position);
        } else {
            System.out.println("Không thấy từ" + str2 + "trong chuỗi");
        }
    }
}
