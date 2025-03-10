import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi thứ nhất: ");
        String str1 = scanner.nextLine();

        System.out.print("Nhập chuỗi thứ hai: ");
        String str2 = scanner.nextLine();

        System.out.print("Nhập chuỗi thứ ba: ");
        String str3 = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(" ").append(str2).append(" ").append(str3);

        String result = sb.toString().toUpperCase();

        System.out.println("Chuỗi sau khi hoàn thành: " + result);

        scanner.close();
    }
}
