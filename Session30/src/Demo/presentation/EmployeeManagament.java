package Demo.presentation;

import Demo.business.model.Preson;
import Demo.presentation.department.DepartmentUI;
import Demo.presentation.employee.EmployeeUI;
import Demo.presentation.statistical.StatisticUI;

import static Demo.presentation.Main.preson;
import static Demo.presentation.Main.scanner;

public class EmployeeManagament {
    public static void displayEmployeeManagement() {
        do {
            System.out.println("------------------Employee Management -----------------");
            System.out.println("1. Quản lí phòng ban");
            System.out.println("2. Quản lí nhân viên");
            System.out.println("3. Thống kê");
            System.out.println("4. Đăng xuất");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    DepartmentUI.displayDepartmentMenu(scanner);
                    break;
                case 2:
                    EmployeeUI.printMenuEmployee(scanner);
                    break;
                case 3:
                    StatisticUI.printMenuStatistic(scanner);
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.err.println("Không hợp lệ, Vui lòng chọn từ 1 đến 4");
            }
        }while (true);
    }

    public static void logout() {

        System.out.println("Bạn có chắc chắn muốn đăng xuất không?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        System.out.print("Chọn: ");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            preson = null;
            System.out.println("Đăng xuất thành công.");
            System.exit(0);
        } else if (choice == 2) {
            System.out.println("Hủy đăng xuất.");
        } else {
            System.err.println("Không hợp lệ, vui lòng chọn 1 - 2");
        }
    }
}
