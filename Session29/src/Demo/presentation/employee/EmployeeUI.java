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
        List<Employee> employeeList = employeeService.findAll();

        int totalPages = (int) Math.ceil((double) employeeList.size() / EMPLOYEE_PER_PAGE);

        do {
            System.out.println("Danh sách trang");
            for (int i = 1; i <= totalPages; i++) {
                System.out.printf("Trang %d\n", i);
            }
            System.out.printf("Lựa chọn của ban (Hoặc ấn 0 để thoát): ");

            int currentPage = Integer.parseInt(sc.nextLine());

            if (currentPage == 0) {
                break;
            }

            if (currentPage < 1 || currentPage > totalPages) {
                System.err.println("Số trang không hợp lệ. Vui lòng nhập lại");
                continue;
            }

            List<Employee> employees = employeeService.paginateEmployee(currentPage);

            employees.forEach(employee -> {
                employee.displayData();
                System.out.println("---------------------------");
            });
        } while (true);
    }

    public void addEmployee(Scanner sc) {
        System.out.println("Nhập vào số nhân viên cần thêm:");
        int size = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < size; i++) {
            System.out.println("Nhập vào thông tin nhân viên thứ " + (i + 1));
            Employee employee = new Employee();
            employee.inputData(sc);
            employeeService.save(employee);
            System.out.println("Thêm nhân viên thành công!");
        }
    }

    public void updateEmployee(Scanner sc) {
        System.out.println("Nhập vào id nhân viên cần cập nhật");
        String employeeId = sc.nextLine();

        if (employeeService.findEmployeeById(employeeId) != null) {
            Employee employee = new Employee();
            employee.setEmployee_id(employeeId);
            employee.inputData(sc);
            boolean result = employeeService.update(employee);

            if (result) {
                System.out.println("Cập nhật thành công!");
            } else {
                System.err.println("Cập nhật thất bại!");
            }
        } else {
            System.err.println("Không tìm thấy nhân viên!");
        }
    }

    public void deleteEmployee(Scanner sc) {
        System.out.println("Nhập vào id nhân viên cần xóa:");
        String employeeId = sc.nextLine();

        if (employeeService.findEmployeeById(employeeId) != null) {
            Employee employee = new Employee();
            employee.setEmployee_id(employeeId);
            employee.setStatus(StatusEmployee.INACTIVE);

            boolean result = employeeService.delete(employee);

            if (result) {
                System.out.println("Cập nhật trạng thái thành công!");
            } else {
                System.err.println("Cập nhật thất bại");
            }
        }else{
            System.err.println("Không tìm thấy nhân viên!");
        }
    }

    public void searchEmployee(Scanner sc) {
        System.out.println("Nhập vào tên cần tìm kiếm");
        String employeeName = sc.nextLine();
        System.out.println("Nhập vào ngày sinh bắt đầu");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateFrom = LocalDate.parse(sc.nextLine(), dtf);
        System.out.println("Nhập vào ngày sinh kết thúc:");
        LocalDate dateTo = LocalDate.parse(sc.nextLine(), dtf);

        if (employeeService.searchEmployee(employeeName, dateFrom, dateTo) != null) {
            List<Employee> employees = employeeService.searchEmployee(employeeName, dateFrom, dateTo);
            employees.forEach(employee -> {
                employee.displayData();
                System.out.println("--------------------------------");
            });
        } else {
            System.err.println("Không có kết quả phù hợp");
        }
    }

    public void sortEmployee(Scanner sc) {
        do {
            List<Employee> employees;
            System.out.println("--------------------SẮP XẾP THEO-------------------");
            System.out.println("1. Lương giảm dần");
            System.out.println("2. Tên tăng dần");
            System.out.println("3. Trở về menu quản lí");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    employees = employeeService.sortEmployeeBySalary();

                    System.out.println("Danh sách sắp xếp nhân viên theo lương giảm dần:");
                    employees.forEach(employee -> {
                        employee.displayData();
                        System.out.println("------------------------------");
                    });
                    break;
                case 2:
                    employees = employeeService.sortEmployeeByName();

                    System.out.println("Danh sách sắp xếp nhân viên theo tên tăng dần:");
                    employees.forEach(employee -> {
                        employee.displayData();
                        System.out.println("------------------------------");
                    });
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 3!");
            }
        } while (true);
    }
}