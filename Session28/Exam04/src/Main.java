
import presentation.AccountUI;
import presentation.FundTransferUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------------MENU QUẢN LÍ NGÂN HÀNG-----------");
            System.out.println("1. Quan lý khách hàng");
            System.out.println("2. Quản lý chuyển tiền");
            System.out.println("3. Thoát");
            System.out.printf("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    AccountUI.printMenuBanking(sc);
                    break;
                case 2:
                    FundTransferUI.displayFundTransfer(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 3!");
            }
        } while (choice != 3);
    }
}
