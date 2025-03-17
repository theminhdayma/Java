abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    public abstract void displayBalance();

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingAccount extends BankAccount {
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() < amount) {
            System.out.println("Tài khoản không đủ tien");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Rút tiền ve thành công");
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Nạp tiền thành công");
    }

    @Override
    public void displayBalance() {
        System.out.println("Số dư tài khoản tiết kiệm: " + getBalance());
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        System.out.println("Rút tiền thành công");
        if (getBalance() < 0) {
            System.out.println("Số dư tài khoản đang âm: " + getBalance());
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Nạp tiền thành công");
    }

    @Override
    public void displayBalance() {
        if (getBalance() >= 0) {
            System.out.println("Số dư tài khoản vãng lai: " + getBalance());
        } else {
            System.out.println("Số dư tài khoản đang âm: " + getBalance());
        }
    }
}

class Bank {
    private BankAccount[] act = new BankAccount[10];

    public void addAccount(BankAccount account) {
        for (int i = 0; i < act.length; i++) {
            if (act[i] == null) {
                act[i] = account;
                return;
            }
        }
        System.out.println("Ngân hàng đã đầy, ko thể thêm tài khoản mới vao ngan hang");
    }

    public void displayAccounts() {
        for (BankAccount account : act) {
            if (account != null) {
                System.out.println("Tài khoản: " + account.getAccountNumber());
                account.displayBalance();
            }
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        CheckingAccount checkingAcc = new CheckingAccount("Nguyen The Cuong", 150);
        SavingAccount savingAcc = new SavingAccount("Nguyễn Kim Anh", 120);
        bank.addAccount(checkingAcc);
        bank.addAccount(savingAcc);
        checkingAcc.withdraw(160);
        savingAcc.withdraw(60);
        savingAcc.deposit(30);
        bank.displayAccounts();
    }
}