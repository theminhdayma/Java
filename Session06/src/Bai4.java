import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi:");
        String input = sc.nextLine();
        sc.close();

        String replacedString = input.replaceAll("[0-9]", "*");

        System.out.println("Chuỗi sau khi thay thế: " + replacedString);
    }
}
