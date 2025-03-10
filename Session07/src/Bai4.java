import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập chuỗi bất kỳ: ");
        String str = sc.nextLine().toLowerCase();

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if (sb.toString().equals(str)) {
            System.out.println("Chuỗi đối xứng");
        } else {
            System.out.println("Chuỗi không đối xứng");
        }
    }
}
