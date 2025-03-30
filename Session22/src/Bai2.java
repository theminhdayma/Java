import java.io.*;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tệp: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        try {
            if (file.exists()) {
                System.out.println("Tệp đã tồn tại!");
            } else {
                if (file.createNewFile()) {
                    throw new ArithmeticException("Tệp đã được tạo!");
                } else {
                    throw new ArithmeticException("Không thể tạo tệp!");
                }
            }
        }catch (ArithmeticException e){
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
