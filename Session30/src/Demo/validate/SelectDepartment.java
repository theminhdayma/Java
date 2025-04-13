package Demo.validate;

import Demo.business.model.Department;
import Demo.presentation.department.DepartmentUI;

import java.util.List;
import java.util.Scanner;

public class SelectDepartment {
    public static int selectDepartmentId(Scanner sc) {
        List<Department> departmentList = DepartmentUI.departmentService.findAll();

        do {
            System.out.println("---------------------DANH SÁCH PHÒNG BAN----------------");
            departmentList.forEach(department -> {
                System.out.printf("%d. %s\n", department.getDepartment_id(), department.getDepartment_name());
            });
            System.out.printf("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            boolean isExist = departmentList.stream().anyMatch(department -> department.getDepartment_id() == choice);

            if (isExist) {
                return choice;
            }

            System.err.println("Id phòng ban không hợp lệ. Vui lòng nhập lại");
        }while (true);
    }
}