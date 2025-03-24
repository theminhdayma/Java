package Bai10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== MENU QUẢN LÝ NHÂN VIÊN ===");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương");
            System.out.println("4. Tính lương trung bình");
            System.out.println("5. Nhân viên có lương cao nhất");
            System.out.println("6. Nhân viên có lương thấp nhất");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    calculateTotalSalary();
                    break;
                case 4:
                    calculateAverageSalary();
                    break;
                case 5:
                    findHighestSalaryEmployee();
                    break;
                case 6:
                    findLowestSalaryEmployee();
                    break;
                case 7:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice != 7);
    }

    private static void addEmployee() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        double salary;
        do {
            System.out.print("Nhập lương nhân viên: ");
            salary = scanner.nextDouble();
            if (salary <= 0) {
                System.out.println("Lương phải lớn hơn 0. Vui lòng nhập lại!");
            }
        } while (salary <= 0);

        int id = nextId++;
        Employee employee = new Employee(id, name, salary);
        employeeMap.put(id, employee);
        System.out.println("Thêm nhân viên thành công!");
    }

    private static void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        System.out.println("\nDANH SÁCH NHÂN VIÊN");
        for (Employee employee : employeeMap.values()) {
            employee.displayInfo();
        }
    }

    private static void calculateTotalSalary() {
        double totalSalary = employeeMap.values().stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Tổng lương của tất cả nhân viên: " + totalSalary);
    }

    private static void calculateAverageSalary() {
        if (employeeMap.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        double averageSalary = employeeMap.values().stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("Lương trung bình của nhân viên: " + averageSalary);
    }

    private static void findHighestSalaryEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        Employee highestSalaryEmployee = employeeMap.values().stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
        System.out.println("Nhân viên có lương cao nhất:");
        highestSalaryEmployee.displayInfo();
    }

    private static void findLowestSalaryEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        Employee lowestSalaryEmployee = employeeMap.values().stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
        System.out.println("Nhân viên có lương thấp nhất:");
        lowestSalaryEmployee.displayInfo();
    }
}

