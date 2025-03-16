package Bai9;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount acc1 = new SavingAccount("SV001", 2000);
        BankAccount acc2 = new CheckingAccount("CH001", 300);
        BankAccount acc3 = new SavingAccount("SV002", 5000);
        BankAccount acc4 = new CheckingAccount("CH002", 1000);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.addAccount(acc4);

        acc1.deposit(500);
        acc2.withdraw(700);
        acc3.withdraw(3500);
        acc4.deposit(300);

        bank.displayBalance();
    }
}
