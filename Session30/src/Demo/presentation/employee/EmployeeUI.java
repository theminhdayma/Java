package Demo.presentation.employee;

import Demo.business.model.employee.Employee;
import Demo.business.model.employee.StatusEmployee;
import Demo.business.service.employee.EmployeeService;
import Demo.business.service.employee.EmployeeServiceImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    public static EmployeeService employeeService = new EmployeeServiceImp();
    public static final int EMPLOYEE_PER_PAGE = 10;

    public static void printMenuEmployee(Scanner sc) {
        EmployeeUI employeeUI = new EmployeeUI();
        do {
            System.out.println("---------------------QUẢN LÍ NHÂN VIÊN------------------");
            System.out.println("1. Danh sách nhân viên có phân trang");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên – Theo khoảng tuổi");
            System.out.println("6. Sắp xếp nhân viên");
            System.out.println("7. Trở về menu chính");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    employeeUI.paginateEmployee(sc);
                    break;
                case 2:
                    employeeUI.addEmployee(sc);
                    break;
                case 3:
                    employeeUI.updateEmployee(sc);
                    break;
                case 4:
                    employeeUI.deleteEmployee(sc);
                    break;
                case 5:
                    employeeUI.searchEmployee(sc);
                    break;
                case 6:
                    employeeUI.sortEmployee(sc);
                    break;
                case 7:
                    System.out.println("Quay lại trang chủ");
                    return;
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 7");
            }
        } while (true);
    }

    public void paginateEmployee(Scanner sc) {
        List<Employee> allEmployees = employeeService.findAll();
        int totalPages = (int) Math.ceil((double) allEmployees.size() / EMPLOYEE_PER_PAGE);

        if (allEmployees.isEmpty()) {
            System.err.println("Không có nhân viên nào trong danh sách.");
            return;
        }

        while (true) {
            System.out.println("--------- Danh sách trang ---------");
            for (int i = 1; i <= totalPages; i++) {
                System.out.printf("Trang %d\n", i);
            }
            System.out.print("Lựa chọn của bạn (hoặc ấn 0 để thoát): ");

            int currentPage = Integer.parseInt(sc.nextLine());

            if (currentPage == 0) break;

            if (currentPage < 1 || currentPage > totalPages) {
                System.err.println("Số trang không hợp lệ. Vui lòng nhập lại.");
                continue;
            }

            List<Employee> paginatedEmployees = employeeService.paginateEmployee(currentPage);
            System.out.println("Trang " + currentPage);
            paginatedEmployees.forEach(employee -> {
                employee.displayData();
                System.out.println("---------------------------");
            });
        }
    }

    public void addEmployee(Scanner sc) {
        System.out.print("Nhập vào số nhân viên cần thêm: ");
        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Nhập vào thông tin nhân viên thứ " + (i + 1));
            Employee employee = new Employee();
            employee.inputData(sc);
            employeeService.save(employee);
            System.out.println("Thêm nhân viên thành công!");
        }
    }

    public void updateEmployee(Scanner sc) {
        System.out.print("Nhập vào ID nhân viên cần cập nhật: ");
        String employeeId = sc.nextLine();

        Employee existingEmployee = employeeService.findEmployeeById(employeeId);
        if (existingEmployee == null) {
            System.err.println("Không tìm thấy nhân viên!");
            return;
        }

        Employee updatedEmployee = new Employee();
        updatedEmployee.setEmployee_id(employeeId);
        updatedEmployee.inputData(sc);

        boolean isUpdated = employeeService.update(updatedEmployee);
        System.out.println(isUpdated ? "Cập nhật thành công!" : "Cập nhật thất bại!");
    }

    public void deleteEmployee(Scanner sc) {
        System.out.print("Nhập vào ID nhân viên cần xóa: ");
        String employeeId = sc.nextLine();

        Employee employee = employeeService.findEmployeeById(employeeId);
        if (employee == null) {
            System.err.println("Không tìm thấy nhân viên!");
            return;
        }

        employee.setStatus(StatusEmployee.INACTIVE);
        boolean isDeleted = employeeService.delete(employee);
        System.out.println(isDeleted ? "Cập nhật trạng thái thành công!" : "Cập nhật thất bại");
    }

    public void searchEmployee(Scanner sc) {
        System.out.print("Nhập vào tên nhân viên cần tìm: ");
        String name = sc.nextLine();

        System.out.print("Nhập ngày sinh bắt đầu (dd/MM/yyyy): ");
        LocalDate fromDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Nhập ngày sinh kết thúc (dd/MM/yyyy): ");
        LocalDate toDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<Employee> result = employeeService.searchEmployee(name, fromDate, toDate);

        if (result == null || result.isEmpty()) {
            System.err.println("Không có kết quả phù hợp.");
        } else {
            result.forEach(employee -> {
                employee.displayData();
                System.out.println("--------------------------------");
            });
        }
    }

    public void sortEmployee(Scanner sc) {
        while (true) {
            System.out.println("----------- SẮP XẾP THEO -----------");
            System.out.println("1. Lương giảm dần");
            System.out.println("2. Tên tăng dần");
            System.out.println("3. Trở về menu quản lý");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            List<Employee> sortedList = null;

            switch (choice) {
                case 1:
                    sortedList = employeeService.sortEmployeeBySalary();
                    System.out.println("Danh sách nhân viên theo lương giảm dần:");
                    break;
                case 2:
                    sortedList = employeeService.sortEmployeeByName();
                    System.out.println("Danh sách nhân viên theo tên tăng dần:");
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 3!");
                    continue;
            }

            if (sortedList != null) {
                sortedList.forEach(employee -> {
                    employee.displayData();
                    System.out.println("------------------------------");
                });
            }
        }
    }
}