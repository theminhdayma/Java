import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000000;
        int min_balance = 50000;

        System.out.print("Nhập số tiền muốn rút: ");
        try {
            int withdrawAmount = Integer.parseInt(sc.nextLine());

            if (withdrawAmount <= 0) {
                throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0!");
            }
            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Số tiền rút vượt quá số dư!");
            }
            if (balance - withdrawAmount < min_balance) {
                throw new IllegalArgumentException("Tài khoản phải duy trì số dư tối thiểu 50.000 VNĐ!");
            }

            balance -= withdrawAmount;
            System.out.println("Rút thành công " + withdrawAmount + " VNĐ!");
            System.out.println("Số dư còn lại: " + balance + " VNĐ");

        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập một số hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
