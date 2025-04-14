package Demo.presentation.department;

import Demo.business.model.Department;
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
        List<Department> allDepartments = departmentService.findAll();

        if (allDepartments.isEmpty()) {
            System.err.println("Không có phòng ban nào trong danh sách.");
            return;
        }

        int totalPages = (int) Math.ceil((double) allDepartments.size() / ITEM_PER_PAGE);

        while (true) {
            System.out.println("--------- Danh sách trang ---------");
            for (int i = 1; i <= totalPages; i++) {
                System.out.printf("Trang %d\n", i);
            }
            System.out.print("Lựa chọn của bạn (hoặc ấn 0 để thoát): ");

            int currentPage;
            try {
                currentPage = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số hợp lệ.");
                continue;
            }

            if (currentPage == 0) break;

            if (currentPage < 1 || currentPage > totalPages) {
                System.err.println("Số trang không hợp lệ. Vui lòng nhập lại.");
                continue;
            }

            List<Department> pageDepartments = departmentService.paginateDepartment(currentPage);
            System.out.println("--------- Trang " + currentPage + " ---------");
            pageDepartments.forEach(dept -> {
                dept.displayData();
                System.out.println("------------------------------");
            });
        }
    }

    public static void addDepartment(Scanner sc) {
        System.out.print("Nhập số lượng phòng ban cần thêm: ");
        int count;
        try {
            count = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Số lượng không hợp lệ.");
            return;
        }

        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin phòng ban thứ " + i + ":");
            Department department = new Department();
            department.inputData(sc);
            departmentService.save(department);
            System.out.println("Thêm phòng ban thành công!");
        }
    }

    public static void updateDepartment(Scanner sc) {
        System.out.print("Nhập ID phòng ban cần cập nhật: ");
        int departmentId;
        try {
            departmentId = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("ID không hợp lệ.");
            return;
        }

        Department existingDepartment = departmentService.findDepartmentById(departmentId);
        if (existingDepartment == null) {
            System.err.println("Không tìm thấy phòng ban!");
            return;
        }

        Department updatedDepartment = new Department();
        updatedDepartment.setDepartment_id(departmentId);
        updatedDepartment.inputData(sc);

        boolean updated = departmentService.update(updatedDepartment);
        System.out.println(updated ? "Cập nhật thành công!" : "Cập nhật thất bại!");
    }

    public static void deleteDepartment(Scanner sc) {
        System.out.print("Nhập ID phòng ban cần xóa: ");
        int departmentId;
        try {
            departmentId = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("ID không hợp lệ.");
            return;
        }

        Department existingDepartment = departmentService.findDepartmentById(departmentId);
        if (existingDepartment == null) {
            System.err.println("Không tìm thấy phòng ban!");
            return;
        }

        boolean hasEmployees = EmployeeUI.employeeService.findAll().stream()
                .anyMatch(emp -> emp.getDepartment_id() == departmentId);

        if (hasEmployees) {
            System.err.println("Phòng ban có nhân viên. Không thể xóa!");
            return;
        }

        System.out.print("Bạn có chắc chắn muốn xóa không? (y/n): ");
        String confirm = sc.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            boolean deleted = departmentService.delete(existingDepartment);
            System.out.println(deleted ? "Xóa phòng ban thành công!" : "Xóa thất bại!");
        }
    }

    public static void searchDepartmentByName(Scanner sc) {
        System.out.print("Nhập tên phòng ban cần tìm: ");
        String name = sc.nextLine().trim();

        List<Department> matchedDepartments = departmentService.findDepartmentByName(name);
        if (matchedDepartments.isEmpty()) {
            System.err.println("Không tìm thấy tên phòng ban!");
            return;
        }

        matchedDepartments.forEach(dept -> {
            dept.displayData();
            System.out.println("-------------------------------");
        });
    }
}
