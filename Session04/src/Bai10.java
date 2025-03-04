import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\n=== MENU ===");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng tất cả các ước của một số");
            System.out.println("4. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số nguyên dương: ");
                    int num1 = scanner.nextInt();
                    boolean isPrime = true;

                    if (num1 < 2) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i <= Math.sqrt(num1); i++) {
                            if (num1 % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        System.out.println(num1 + " là số nguyên tố.");
                    } else {
                        System.out.println(num1 + " không phải là số nguyên tố.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập số cần kiểm tra: ");
                    int num2 = scanner.nextInt();
                    int sum1 = 0;

                    if (num2 < 1){
                        System.out.println("Số không hợp lệ");
                        break;
                    } else {
                        for (int i = 1; i < num2; i++) {
                            if (num2 % i == 0) {
                                sum1 += i;
                            }
                        }
                    }

                    if (sum1 == num2) {
                        System.out.println(num2 + " là số hoàn hảo.");
                    } else {
                        System.out.println(num2 + " không phải là số hoàn hảo.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số nguyên dương: ");
                    int num3 = scanner.nextInt();
                    int sum2 = 0;

                    if (num3 < 1){
                        System.out.println("Số không hợp lệ");
                        break;
                    } else {
                        System.out.print("Các ước của " + num3 + " là: ");
                        for (int i = 1; i <= num3; i++) {
                            if (num3 % i == 0) {
                                System.out.print(i + " ");
                                sum2 += i;
                            }
                        }
                        System.out.println("\nTổng tất cả các ước của " + num3 + " là: " + sum2);
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1 đến 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
