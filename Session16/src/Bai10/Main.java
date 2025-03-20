package Bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudentByName();
                    break;
                case 4:
                    classifyStudents();
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
        } while (choice != 5);
    }

    private static void inputStudents() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            System.out.print("Mã sinh viên: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Họ và tên: ");
            String name = scanner.nextLine();
            System.out.print("Điểm GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            students.add(new Student(id, name, gpa));
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        System.out.println("DANH SÁCH SINH VIÊN");
        for (Student student : students) {
            student.display();
        }
    }

    private static void searchStudentByName() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                student.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có tên: " + searchName);
        }
    }

    private static void classifyStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }

        System.out.println("\nDanh sách sinh viên đã phân loại:");
        for (Student student : students) {
            student.display();
            System.out.println("Xếp loại: " + student.classify());
        }
    }
}
