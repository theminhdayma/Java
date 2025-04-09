package business.model;

import java.util.Scanner;

public class Account {
    private int id;
    private String name;
    private double balance;
    private Status status;

    public Account() {
    }

    public Account(int id, String name, double balance, Status status) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner sc) {
        System.out.println("Nhập tên tài khoản:");
        this.name = sc.nextLine();

        System.out.println("Nhap số dư:");
        this.balance = Double.parseDouble(sc.nextLine());

        System.out.println("Nhập trạng thái");
        this.status = Status.valueOf(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
