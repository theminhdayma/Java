package Bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        accounts.add(new BankAccount("1", 500000));
        accounts.add(new BankAccount("2", 300000));

        int choice;
        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Chuyển tiền");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                scanner.next();
                System.out.print("Chọn chức năng: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleDeposit(scanner);
                    break;
                case 2:
                    handleWithdraw(scanner);
                    break;
                case 3:
                    handleTransfer(scanner);
                    break;
                case 4:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 4.");
            }
        } while (choice != 4);
    }

    private static void handleDeposit(Scanner scanner) {
        try {
            System.out.print("Nhập số tài khoản: ");
            String accountId = scanner.nextLine();
            BankAccount account = findAccount(accountId);

            System.out.print("Nhập số tiền cần gửi: ");
            double amount = Double.parseDouble(scanner.nextLine());

            account.deposit(amount);
        } catch (AccountNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } catch (InvalidAmountException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void handleWithdraw(Scanner scanner) {
        try {
            System.out.print("Nhập số tài khoản: ");
            String accountId = scanner.nextLine();
            BankAccount account = findAccount(accountId);

            System.out.print("Nhập số tiền cần rút: ");
            double amount = Double.parseDouble(scanner.nextLine());

            account.withdraw(amount);
        } catch (AccountNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void handleTransfer(Scanner scanner) {
        try {
            System.out.print("Nhập số tài khoản nguồn: ");
            String senderId = scanner.nextLine();
            BankAccount sender = findAccount(senderId);

            System.out.print("Nhập số tài khoản đích: ");
            String receiverId = scanner.nextLine();
            BankAccount receiver = findAccount(receiverId);

            System.out.print("Nhập số tiền cần chuyển: ");
            double amount = Double.parseDouble(scanner.nextLine());

            sender.transfer(receiver, amount);
        } catch (AccountNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static BankAccount findAccount(String accountId) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Tài khoản " + accountId + " không tồn tại!");
    }
}
