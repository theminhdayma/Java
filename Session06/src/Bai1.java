import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một chuỗi bất kỳ:");
        String str = sc.nextLine().trim();
        sc.close();

        String[] words = str.split("\\s+");

        if (words.length > 0) {
            System.out.println("Số từ trong chuỗi: " + words.length);
        } else {
            System.out.println("Khoảng trắng");
        }
    }
}
