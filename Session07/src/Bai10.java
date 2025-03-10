import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();

        System.out.print("Nhập chuỗi bất kỳ: ");
        str.append(scanner.nextLine());

        int choice;
        do {
            // Hiển thị menu
            System.out.println("\n===== MENU QUẢN LÝ CHUỖI =====");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kỳ");
            System.out.println("3. Xóa một đoạn trong chuỗi");
            System.out.println("4. Thay thế một đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi toàn bộ chuỗi thành chữ hoa/chữ thường");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    str.reverse();
                    System.out.println("Chuỗi sau khi đảo ngược: " + str);
                    break;
                case 2:
                    System.out.print("Nhập chuỗi con cần chèn: ");
                    String subStr = scanner.nextLine();
                    System.out.print("Nhập vị trí cần chèn: ");
                    int insertPos = scanner.nextInt();
                    scanner.nextLine();
                    if (insertPos >= 0 && insertPos <= str.length()) {
                        str.insert(insertPos, subStr);
                        System.out.println("Chuỗi sau khi chèn: " + str);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập vị trí bắt đầu xóa: ");
                    int startDel = scanner.nextInt();
                    System.out.print("Nhập vị trí kết thúc xóa: ");
                    int endDel = scanner.nextInt();
                    scanner.nextLine();
                    if (startDel >= 0 && endDel <= str.length() && startDel < endDel) {
                        str.delete(startDel, endDel);
                        System.out.println("Chuỗi sau khi xóa: " + str);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập vị trí bắt đầu thay thế: ");
                    int startRep = scanner.nextInt();
                    System.out.print("Nhập vị trí kết thúc thay thế: ");
                    int endRep = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập chuỗi thay thế: ");
                    String replaceStr = scanner.nextLine();
                    if (startRep >= 0 && endRep <= str.length() && startRep < endRep) {
                        str.replace(startRep, endRep, replaceStr);
                        System.out.println("Chuỗi sau khi thay thế: " + str);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;
                case 5:
                    System.out.println("1 là hoa / 2 là thường: ");
                    int convertChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (convertChoice == 1) {
                        str = new StringBuilder(str.toString().toUpperCase());
                        System.out.println("Chuỗi sau khi chuyển thành chữ hoa: " + str);
                    } else if (convertChoice == 2) {
                        str = new StringBuilder(str.toString().toLowerCase());
                        System.out.println("Chuỗi sau khi chuyển thành chữ thường: " + str);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Không hợp lệ");
            }
        } while (choice != 6);

        scanner.close();
    }
}
