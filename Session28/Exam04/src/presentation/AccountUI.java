package presentation;

import business.model.Account;
import business.model.Status;
import business.service.account.AccountService;
import business.service.account.AccountServiceImp;

import java.util.List;
import java.util.Scanner;

public class AccountUI {
    public static AccountService accountService = new AccountServiceImp();
    public static void printMenuBanking(Scanner sc) {
        AccountUI accountUI = new AccountUI();
        do {
            System.out.println("--------------------------ACCOUNT MENU------------------------");
            System.out.println("1. Danh sách tài khoản");
            System.out.println("2. Tạo 1 tài khoan");
            System.out.println("3. Cập nhật tài khoản");
            System.out.println("4. Xóa tài khoản");
            System.out.println("5. Chuyen khoản");
            System.out.println("6. Tra cứu số dư");
            System.out.println("7. Thoát");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    accountUI.displayAccounts();
                    break;
                case 2:
                    accountUI.addAccount(sc);
                    break;
                case 3:
                    accountUI.updateAccount(sc);
                    break;
                case 4:
                    accountUI.deleteAccount(sc);
                    break;
                case 5:
                    accountUI.fundTransfer(sc, accountService);
                    break;
                case 6:
                    accountUI.checkBalance(sc);
                    break;
                case 7:
                    return;
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 7!");
            }
        } while (true);
    }

    public void displayAccounts(){
        List<Account> accountList = accountService.findAll();

        accountList.forEach(System.out::println);
    }

    public void addAccount(Scanner sc) {
        Account account = new Account();
        account.inputData(sc);

        boolean result = accountService.add(account);

        if (result) {
            System.out.println("Thêm thành công!");
        }else{
            System.err.println("Thêm thât bại");
        }
    }

    public void updateAccount(Scanner sc) {
        System.out.println("Nhập vào id tài khoản cần cập nhật:");
        int id = Integer.parseInt(sc.nextLine());
        if(accountService.findAccountById(id) != null) {
            Account account = new Account();
            account.setId(id);

            System.out.println("Nhập tên tài khoản mới: ");
            account.setName(sc.nextLine());

            System.out.println("Nhập trạng thái:");
            account.setStatus(Status.valueOf(sc.nextLine()));

            boolean result = accountService.update(account);
            if(result){
                System.out.println("Cập nhật thành công!");
            }else{
                System.err.println("Cập nhật thất bại!");
            }
        }else{
            System.err.println("Không tồn tại tài khoản");
        }
    }

    public void deleteAccount(Scanner sc) {
        System.out.println("Nhâp vào stk cần xóa:");
        int id = Integer.parseInt(sc.nextLine());

        if(accountService.findAccountById(id) != null) {
            Account account = new Account();
            account.setId(id);
            account.setStatus(Status.INACTIVE);

            boolean result = accountService.delete(account);
            if(result){
                System.out.println("Cập nhật trạng thái thành công!");
            }else{
                System.err.println("Cập nhật trạng thái thất bại!");
            }
        }
    }

    public void checkBalance(Scanner sc) {
        System.out.println("Nhâp vào stk cần kiểm tra số dư:");
        int id = Integer.parseInt(sc.nextLine());

        Account account = accountService.findAccountById(id);

        if(account != null) {
            double getBalance = accountService.checkBalance(account);
            System.out.println("Số dư của tk " + id + " là: " + getBalance);
        }else{
            System.err.println("Không tìm thấy tài khoản");
        }
    }

    public void fundTransfer(Scanner sc, AccountService accountService) {
        System.out.println("Nhập mã tài khoản cần gửi:");
        int accSenderId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên tài khoản gưi:");
        String accSenderName = sc.nextLine();

        System.out.println("Nhập mã tài khoản người nhận:");
        int accRecieverId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên tài khoản ng nhận:");
        String accRecieverName = sc.nextLine();

        System.out.println("Nhập so tien gửi: ");
        double amount = Double.parseDouble(sc.nextLine());

        int result = accountService.fundsTransfer(accSenderId, accSenderName, accRecieverId, accRecieverName, amount);

        switch (result) {
            case 1:
                System.err.println("Thông tin tài khoản nguời gửi không chính xác");
                break;
            case 2:
                System.err.println("Thông tin tài khoản nguời nhận không chính xác");
                break;
            case 3:
                System.err.println("Số dư tài khoan không đủ");
                break;
            case 4:
                System.out.println("Chuyển thành công!");
                break;
            case 5:
                System.err.println("Lỗi k xác định!");
                break;
            default:
                System.err.println("Vui lòng chọn lại từ 1 - 5");
        }
    }
}
