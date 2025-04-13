package Demo.presentation.department;

import Demo.business.model.Department;
import Demo.business.model.employee.Employee;
import Demo.business.service.department.DepartmentService;
import Demo.business.service.department.DepartmentServiceImp;
import Demo.presentation.employee.EmployeeUI;

import java.util.List;
import java.util.Scanner;

public class DepartmentUI {
    public static DepartmentService departmentService = new DepartmentServiceImp();
    public static final int ITEM_PER_PAGE = 5;

    public static void displayDepartmentMenu(Scanner scanner) {
        do {
            System.out.println("\n--------------DEPARTMENT MENU--------------");
            System.out.println("1. Danh sách phòng ban có phân trang");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhâật phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Tìm kiếm phòng ban theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    pagination(scanner);
                    break;
                case 2:
                    addDepartment(scanner);
                    break;
                case 3:
                    updateDepartment(scanner);
                    break;
                case 4:
                    deleteDepartment(scanner);
                    break;
                case 5:
                    searchDepartmentByName(scanner);
                    break;
                case 6:
                    System.out.println("Quay lại trang chủ");
                    return;
                default:
                    System.err.println("Lựa cho không họp lệ, Vui lòng chọn lại");
            }
        } while (true);
    }

    public static void pagination(Scanner sc) {
        List<Department> departmentList = departmentService.findAll();

        int totalPages = (int) Math.ceil((double) departmentList.size() / ITEM_PER_PAGE);

        if (departmentList.isEmpty()) {
            System.err.println("Không có phòng ban nào trong danh sách.");
            return;
        }

        do {
            System.out.println("--------- Danh sách trang ---------");
            for (int i = 1; i <= totalPages; i++) {
                System.out.printf("Trang %d\n", i);
            }
            System.out.printf("Lựa chọn của bạn (hoặc ấn 0 để thoát): ");

            int currentPage = Integer.parseInt(sc.nextLine());

            if (currentPage == 0) {
                break;
            }

            if (currentPage < 1 || currentPage > totalPages) {
                System.err.println("Số trang không hợp lệ. Vui lòng nhập lại");
                continue;
            }

            List<Department> paginationList = departmentService.paginateDepartment(currentPage);

            System.out.println("Trang " + currentPage);
            paginationList.forEach(department -> {
                department.displayData();
                System.out.println("------------------------------");
            });
        } while (true);
    }

    public static void addDepartment(Scanner sc) {
        System.out.println("Nhập số luợng phòng ban cần thêm:");
        int size = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin phòng ban thứ " + (i + 1) + ":");
            Department department = new Department();
            department.inputData(sc);
            departmentService.save(department);
            System.out.println("Thêm phòng ban thành công!");
        }
    }

    public static void updateDepartment(Scanner sc) {
        System.out.println("Nhập id phòng ban cần cập nhật:");
        int departmentId = Integer.parseInt(sc.nextLine());

        if (departmentService.findDepartmentById(departmentId) != null) {
            Department department = new Department();
            department.setDepartment_id(departmentId);

            department.inputData(sc);

            boolean result = departmentService.update(department);

            if (result) {
                System.out.println("Cập nhật thành công!");
            } else {
                System.err.println("Cập nhật thất bại!");
            }
        } else {
            System.err.println("Không tìm thấy phòng ban!");
        }
    }

    public static void deleteDepartment(Scanner sc) {
        System.out.println("Nhập vào id phòng ban cần xóa:");
        int departmentId = Integer.parseInt(sc.nextLine());

        List<Employee> employees = EmployeeUI.employeeService.findAll();

        List<Employee> filterEmployees = employees.stream()
                .filter(employee -> employee.getDepartment_id() == departmentId)
                .toList();

        if (!filterEmployees.isEmpty()) {
            System.err.println("Phòng ban có nhân viên. Không thể xóa!");
            return;
        }

        if (departmentService.findDepartmentById(departmentId) != null) {
            System.out.println("Bạn có chắc chắn muốn xóa không?");
            String confirm = sc.nextLine();

            if (confirm.equals("y")) {
                Department department = new Department();
                department.setDepartment_id(departmentId);
                boolean result = departmentService.delete(department);

                if (result) {
                    System.out.println("Xóa phòng ban thành công!");
                } else {
                    System.err.println("Xóa thất bại");
                }
            }
        } else {
            System.err.println("Không tìm thấy phòng ban!");
        }
    }

    public static void searchDepartmentByName(Scanner sc) {
        System.out.println("Nhập vào tên phòng ban cần tìm");
        String departmentName = sc.nextLine();

        if (!departmentService.findDepartmentByName(departmentName).isEmpty()) {
            List<Department> departmentList = departmentService.findDepartmentByName(departmentName);

            departmentList.forEach(department -> {
                department.displayData();
                System.out.println("-------------------------------");
            });
        } else {
            System.err.println("Không tìm thấy tên phòng ban!");
        }
    }
}
