package Demo.business.model;

import java.util.Scanner;

public class Preson {
    private int id;
    private String username;
    private String password;
    private boolean status;

    public Preson() {}

    public Preson(int id, String username, String password, boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên tài khoản: ");
        this.username = scanner.nextLine();

        System.out.println("Nhập password: ");
        this.password = scanner.nextLine();
    }
}
