package Demo.business.model;

import Demo.validate.rule.StringRule;
import Demo.validate.Validator;

import java.util.Scanner;

public class Department {
    private int department_id;
    private String department_name;
    private String department_description;
    private boolean department_status;

    public Department() {}

    public Department(int department_id, String department_name, String department_description, boolean department_status) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_description = department_description;
        this.department_status = department_status;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_description() {
        return department_description;
    }

    public void setDepartment_description(String department_description) {
        this.department_description = department_description;
    }

    public boolean isDepartment_status() {
        return department_status;
    }

    public void setDepartment_status(boolean department_status) {
        this.department_status = department_status;
    }

    public void inputData(Scanner scanner) {
        this.department_name = Validator.validateInputString(scanner, "Nhập tên phòng ban", new StringRule(10, 100));
        this.department_description = Validator.validateInputString(scanner, "Nhập mô tả: ", new StringRule(0, 255));
        this.department_status = Validator.validateInputBoolean(scanner, "Nhập trạng thái:");
    }

    public void displayData() {
        System.out.printf("Department ID: %d\n", department_id);
        System.out.printf("Department Name: %s\n", department_name);
        System.out.printf("Description: %s\n", department_description);
        System.out.printf("Status: %s\n", department_status ? "Đang hoạt động" : "Không hoạt động");
    }
}
