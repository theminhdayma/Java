package Bai9;

class SavingAccount extends BankAccount {
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ");
        } else {
            balance -= amount;
            System.out.println("Rút " + amount + " thành công từ tài khoản " + accountNumber);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Nạp " + amount + " vào tài khoản " + accountNumber);
    }

    @Override
    public void displayBalance() {
        System.out.println("Tài khoản " + accountNumber + " có số dư: $" + balance);
    }
}
