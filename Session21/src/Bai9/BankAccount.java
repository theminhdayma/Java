package Bai9;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền gửi phải lớn hơn 0!");
        }
        balance += amount;
        System.out.println("Gửi tiền thành công! Số dư mới: " + balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền rút phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Số dư không đủ để rút tiền!");
        }
        balance -= amount;
        System.out.println("Rút tiền thành công! Số dư còn lại: " + balance);
    }

    public void transfer(BankAccount receiver, double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền chuyển phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Số dư không đủ để chuyển tiền!");
        }
        this.balance -= amount;
        receiver.balance += amount;
        System.out.println("Chuyển tiền thành công! Số dư mới của tài khoản gốc là: " + balance);
    }
}
