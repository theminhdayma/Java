import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try {
            System.out.print("Nhập vào chỉ số phần tử: ");
            int index = sc.nextInt();
            int value = numbers[index];
            System.out.println("Giá trị tại " + index + " là: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Lỗi: Chỉ số nhập vào không hợp lệ! Vui lòng nhập từ 0 đến " + (numbers.length - 1));
        } catch (Exception e) {
            System.out.println("Lỗi: Dữ liệu nhập vào không hợp lệ! Vui lòng nhập số nguyên.");
            e.printStackTrace();
        }
    }
}
