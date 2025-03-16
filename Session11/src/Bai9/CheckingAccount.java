package Bai9;

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Rút " + amount + " từ tài khoản " + accountNumber + ". Số dư mới: $" + balance);
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
