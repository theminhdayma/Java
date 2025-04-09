package presentation;

import business.model.FundTransfer;
import business.service.fundTransfer.FundTrsService;
import business.service.fundTransfer.FundTrsServiceImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FundTransferUI {
    private final FundTrsService fundTrsService = new FundTrsServiceImp();
    public static void displayFundTransfer(Scanner sc) {
        FundTransferUI fundTransferUI = new FundTransferUI();
        do {
            System.out.println("----------------------FUND TRANSFER MENU-------------------");
            System.out.println("1. Lịch sử giao dịch");
            System.out.println("2. Thống kê số tiền chuyển trong khoản tu ngay den ngay");
            System.out.println("3. Thống kê số tiền nhận theo tai khoản");
            System.out.println("4. Thống kê số giao dịch thành công từ ngày đến ngày");
            System.out.println("5. Thoát");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    fundTransferUI.historyTransfer();
                    break;
                case 2:
                    fundTransferUI.totalMoneyOnDay(sc);
                    break;
                case 3:
                    fundTransferUI.getTotalMoneyByAccount(sc);
                    break;
                case 4:
                    fundTransferUI.countSuccessedFundTransfer(sc);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 5!");
            }
        } while (true);
    }

    public void historyTransfer() {
        List<FundTransfer> fundTransferList = fundTrsService.getAllFundTransfer();

        System.out.println("Lịch sử giao dịch:");
        fundTransferList.forEach(System.out::println);
    }

    public void totalMoneyOnDay(Scanner sc) {
        System.out.println("Nhập ngày bắt đầu:");
        LocalDate from = LocalDate.parse(sc.nextLine());

        System.out.println("Nhập ngày kết thúc:");
        LocalDate to = LocalDate.parse(sc.nextLine());

        if (fundTrsService.totalMoney(from, to) > 0) {
            double totalMoney = fundTrsService.totalMoney(from, to);
            System.out.println("Tổng số tiền đã giao dịch là: " + totalMoney);
        }else{
            System.err.println("Không có giao dịch trong khoảng tg trên!");
        }
    }

    public void getTotalMoneyByAccount(Scanner sc) {
        System.out.println("Nhập vào số tài khoan cần thống kê:");
        int accReceiverId = Integer.parseInt(sc.nextLine());

        if (fundTrsService.getTotalMoneyByAccount(accReceiverId) > 0) {
            double totalMoney = fundTrsService.getTotalMoneyByAccount(accReceiverId);
            System.out.println("Tổng số tiền nhận của tài khoản " + accReceiverId + ": " + totalMoney);
        }
    }

    public void countSuccessedFundTransfer(Scanner sc) {
        System.out.println("Nhập ngày bắt đầu:");
        LocalDate from = LocalDate.parse(sc.nextLine());

        System.out.println("Nhập ngày kết thúc:");
        LocalDate to = LocalDate.parse(sc.nextLine());

        if (fundTrsService.countSuccessedFundTransfer(from, to) > 0) {
            int count = fundTrsService.countSuccessedFundTransfer(from, to);
            System.out.println("Số giao dịch thành công trong khoảng tg đó là: " + count);
        }else{
            System.err.println("Không có giao dịch thành công nào trong khoảng tg đó!");
        }
    }
}
