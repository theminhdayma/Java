package Demo.presentation;

import Demo.business.model.Preson;
import Demo.business.model.employee.Employee;
import Demo.business.service.preson.LoginService;
import Demo.business.service.preson.LoginServiceImp;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static Preson preson = null;
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("----------- MENU-------------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Thoát");

            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Đang thoát chương trình ....");
                    break;
            }
        }while (true);
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginServiceImp();

        do {
            try {
                Preson user = new Preson();
                user.inputData(scanner);

                boolean isLoggedIn = loginService.login(user.getUsername(), user.getPassword());

                if (isLoggedIn) {
                    System.out.println("Đăng nhập thành công");
                    preson = user;
                    EmployeeManagament.displayEmployeeManagement();
                    return;
                } else {
                    System.err.println("Tài khoản hoặc mật khẩu không chính xác. Vui lòng thử lại!\n");
                }

            } catch (Exception e) {
                System.err.println("Lỗi không xác định: " + e.getMessage());
            }
        } while (true);
    }
}
