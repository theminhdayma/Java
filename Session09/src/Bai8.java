// Lớp BankAccount để quản lý tài khoản ngân hàng
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp thành công: " + amount + " VND");
        } else {
            System.out.println("Số tiền nạp không hợp lệ!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để rút!");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Rút thành công: " + amount + " VND");
        } else {
            System.out.println("Số tiền rút không hợp lệ!");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để chuyển!");
        } else if (amount > 0) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println("Chuyển thành công: " + amount + " VND đến " + recipient.accountHolder);
        } else {
            System.out.println("Số tiền chuyển không hợp lệ!");
        }
    }

        public void display() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số dư hiện tại: " + balance + " VND");
        System.out.println("---------------------------");
    }
}

public class Bai8 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(
                "18231220052005",
                "Nguyễn Thế Minh",
                10000000
        );
        BankAccount account2 = new BankAccount(
                "0364577211",
                "Trần Nho Hà",
                5000000
        );

        System.out.println("Thông tin tài khoản ban đầu:");
        account1.display();
        account2.display();

        System.out.println("Nạp 2tr vào tài khoản 1");
        account1.deposit(2000000);
        account1.display();

        System.out.println("Rú 1tr từ tài khoản 2");
        account2.withdraw(1000000);
        account2.display();

        System.out.println("Chuyển 2tr5 từ tài khoản 1 sang tài khoản 2");
        account1.transfer(account2, 2500000);

        System.out.println("Thông tin tài khoản sau giao dịch:");
        account1.display();
        account2.display();
    }
}
