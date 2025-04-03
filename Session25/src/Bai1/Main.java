package Bai1;

public class Main {
    public static void main(String[] args) {
        Account account1 = Account.getInstance();
        account1.setId(1);
        account1.setName("Thế Minh");
        account1.setAge(20);

        Account account2 = Account.getInstance();

        System.out.println("Account1 ID: " + account1.getId());
        System.out.println("Account2 ID: " + account2.getId());
        System.out.println("Account1 và Account2 có cùng là một Object không? " + (account1 == account2));
    }
}
