import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập chuỗi bất kỳ: ");
        String str = sc.nextLine();

        System.out.println("Chuỗi ban đầu: " + str);

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        System.out.println("Chuỗi sau khi đảo ngược: " + sb);
    }
}
